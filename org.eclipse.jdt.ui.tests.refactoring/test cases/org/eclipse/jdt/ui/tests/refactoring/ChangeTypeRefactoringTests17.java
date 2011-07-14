/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This is an implementation of an early-draft specification developed under the Java
 * Community Process (JCP) and is made available for testing and evaluation purposes
 * only. The code is not compatible with any specification of the JCP.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.ui.tests.refactoring;

import junit.framework.Test;

public class ChangeTypeRefactoringTests17 extends ChangeTypeRefactoringTests {

	private static final Class clazz= ChangeTypeRefactoringTests17.class;

	public ChangeTypeRefactoringTests17(String name) {
		super(name);
	}

	public static Test suite() {
		return new Java17Setup(new NoSuperTestsSuite(clazz));
	}

	public static Test setUpTest(Test someTest) {
		return new Java17Setup(someTest);
	}

	@Override
	protected String getTestFileName(boolean positive, boolean input) {
		String fileName= TEST_PATH_PREFIX + getRefactoringPath();

		fileName+= (positive ? "positive17/" : "negative17/");
		fileName += getSimpleTestFileName(input);
		return fileName;
	}

	// tests that are supposed to fail

	public void testUnionType() throws Exception {
		failHelper1(12, 65, 12, 67, 4, "java.lang.Object");
	}
}