/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
package org.eclipse.jdt.internal.corext.refactoring.code.flow;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.*;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.corext.refactoring.Assert;
import org.eclipse.jdt.internal.corext.refactoring.util.Selection;
import org.eclipse.jdt.internal.corext.textmanipulation.TextRange;

public class InputFlowAnalyzer extends FlowAnalyzer {
	
	private static class LoopReentranceVisitor extends FlowAnalyzer {
		private Selection fSelection;
		private AstNode fLoopNode;
		public LoopReentranceVisitor(FlowContext context, Selection selection, AstNode loopNode) {
			super(context);
			fSelection= selection;
			fLoopNode= loopNode;
		}
		protected boolean traverseRange(int start, int end) {
			return true; // end <= fSelection.end || fSelection.enclosedBy(start, end);	
		}
		protected boolean createReturnFlowInfo(ReturnStatement node) {
			// Make sure that the whole return statement is selected or located before the selection.
			return node.sourceEnd <= fSelection.end;
		}	
		protected AstNode getLoopNode() {
			return fLoopNode;
		}
		public void process(AstNode node, BlockScope scope) {
			fFlowContext.setLoopReentranceMode(true);	
			node.traverse(this, scope);
			fFlowContext.setLoopReentranceMode(false);
		}
		public void endVisit(DoStatement node, BlockScope scope) {
			if (skipNode(node))
				return;
			DoWhileFlowInfo info= createDoWhile();
			setFlowInfo(node, info);
			info.mergeAction(getFlowInfo(node.action), fFlowContext);
			// No need to merge the condition. It was already considered by the InputFlowAnalyzer.
			info.removeLabel(null);	
		}
		public void endVisit(ForStatement node, BlockScope scope) {
			if (skipNode(node))
				return;
			FlowInfo initInfo= createSequential(node.initializations);
			FlowInfo conditionInfo= getFlowInfo(node.condition);
			FlowInfo incrementInfo= createSequential(node.increments);
			FlowInfo actionInfo= getFlowInfo(node.action);
			ForFlowInfo forInfo= createFor();
			setFlowInfo(node, forInfo);
			// the for statement is the outermost loop. In this case we only have
			// to consider the increment, condition and action.
			if (node == fLoopNode) {
				forInfo.mergeIncrement(incrementInfo, fFlowContext);
				forInfo.mergeCondition(conditionInfo, fFlowContext);
				forInfo.mergeAction(actionInfo, fFlowContext);
				forInfo.removeLabel(null);
			} else {
				// we have to merge two different cases. One if we reenter the for statement
				// immediatelly (that means we have to consider increments, condition and action
				// ) and the other case if we reenter the for in the next loop of
				// the outer loop. Then we have to consider initializations, condtion and action.
				// For a conditional flow info that means:
				// (initializations | increments) & condition & action.
				GenericConditionalFlowInfo initIncr= new GenericConditionalFlowInfo();
				initIncr.merge(initInfo, fFlowContext);
				initIncr.merge(incrementInfo, fFlowContext);
				forInfo.mergeAccessModeSequential(initIncr, fFlowContext);
				forInfo.mergeCondition(conditionInfo, fFlowContext);
				forInfo.mergeAction(actionInfo, fFlowContext);
			}
			forInfo.removeLabel(null);
		}
	}
	
	private Selection fSelection;
	private LoopReentranceVisitor fLoopReentranceVisitor;

	public InputFlowAnalyzer(FlowContext context, Selection selection) {
		super(context);
		fSelection= selection;
		Assert.isNotNull(fSelection);
	}

	public FlowInfo perform(AbstractMethodDeclaration method, ClassScope scope) {
		FlowContext context= getFlowContext();
		method.traverse(this, scope);
		return getFlowInfo(method);
	}
	
	protected boolean traverseRange(int start, int end) {
		return end >= fSelection.end;
	}
	
	protected boolean createReturnFlowInfo(ReturnStatement node) {
		// Make sure that the whole return statement is located after the selection. There can be cases like
		// return i + [x + 10] * 10; In this case we must not create a return info node.		
		return node.sourceStart >= fSelection.end;
	}
	
	public boolean visit(DoStatement node, BlockScope scope) {
		createLoopReentranceVisitor(node);
		return super.visit(node, scope);			
	}
	
	public boolean visit(ForStatement node, BlockScope scope) {
		createLoopReentranceVisitor(node);
		return super.visit(node, scope);			
	}
	
	public boolean visit(WhileStatement node, BlockScope scope) {
		createLoopReentranceVisitor(node);
		return super.visit(node, scope);			
	}
	
	private void createLoopReentranceVisitor(AstNode node) {
		if (fLoopReentranceVisitor == null)
			fLoopReentranceVisitor= new LoopReentranceVisitor(fFlowContext, fSelection, node);
	}
	
	public void endVisit(ConditionalExpression node, BlockScope scope) {
		if (skipNode(node))
			return;
		if ((node.valueIfTrue != null && fSelection.coveredBy(node.valueIfTrue)) ||
				(node.valueIfFalse != null && fSelection.coveredBy(node.valueIfFalse))) {
			GenericSequentialFlowInfo info= createSequential();
			setFlowInfo(node, info);
			endVisitConditional(info, node.condition, new AstNode[] {node.valueIfTrue, node.valueIfFalse});
		} else {
			super.endVisit(node, scope);
		}
	}
	
	public void endVisit(DoStatement node, BlockScope scope) {
		super.endVisit(node, scope);
		handleLoopReentrance(node, scope);
	}

	public void endVisit(IfStatement node, BlockScope scope) {
		if (skipNode(node))
			return;
		if ((node.thenStatement != null && fSelection.coveredBy(node.thenStatement)) || 
				(node.elseStatement != null && fSelection.coveredBy(node.elseStatement))) {
			GenericSequentialFlowInfo info= createSequential();
			setFlowInfo(node, info);
			endVisitConditional(info, node.condition, new AstNode[] {node.thenStatement, node.elseStatement});
		} else {
			super.endVisit(node, scope);
		}
	}
	
	public void endVisit(ForStatement node, BlockScope scope) {
		super.endVisit(node, scope);
		handleLoopReentrance(node, scope);
	}
	
	public void endVisit(SwitchStatement node, BlockScope scope) {
		if (skipNode(node))
			return;
		SwitchData data= createSwitchData(node);
		TextRange[] ranges= data.getRanges();
		for (int i= 0; i < ranges.length; i++) {
			TextRange range= ranges[i];
			if (fSelection.coveredBy(range.getOffset(), range.getInclusiveEnd())) {
				GenericSequentialFlowInfo info= createSequential();
				setFlowInfo(node, info);
				info.merge(getFlowInfo(node.testExpression), fFlowContext);
				info.merge(data.getInfo(i), fFlowContext);
				info.removeLabel(null);
				return;
			}
		}
		super.endVisit(node, data);
	}
	
	public void endVisit(WhileStatement node, BlockScope scope) {
		super.endVisit(node, scope);
		handleLoopReentrance(node, scope);
	}
	
	private void endVisitConditional(GenericSequentialFlowInfo info, AstNode condition, AstNode[] branches) {
		info.merge(getFlowInfo(condition), fFlowContext);
		for (int i= 0; i < branches.length; i++) {
			AstNode branch= branches[i];
			if (branch != null && fSelection.coveredBy(branch)) {
				info.merge(getFlowInfo(branch), fFlowContext);
				break;
			}
		}
	}
	
	private void handleLoopReentrance(AstNode node, BlockScope scope) {
		if (!fSelection.enclosedBy(node) || fLoopReentranceVisitor.getLoopNode() != node)
			return;
		
		fLoopReentranceVisitor.process(node, scope);
		GenericSequentialFlowInfo info= createSequential();
		info.merge(getFlowInfo(node), fFlowContext);
		info.merge(fLoopReentranceVisitor.getFlowInfo(node), fFlowContext);
		setFlowInfo(node, info);
	}
}