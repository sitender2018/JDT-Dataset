/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
package org.eclipse.jdt.internal.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

/**
 * Bundle of most images used by the Java plugin.
 */
public class JavaPluginImages {

	private static final String NAME_PREFIX= "org.eclipse.jdt.ui."; //$NON-NLS-1$
	private static final int    NAME_PREFIX_LENGTH= NAME_PREFIX.length();

	private static URL fgIconBaseURL= null;
	
	// Determine display depth. If depth > 4 then we use high color images. Otherwise low color
	// images are used
	static {
		String pathSuffix= "icons/full/"; //$NON-NLS-1$
		try {
			fgIconBaseURL= new URL(JavaPlugin.getDefault().getDescriptor().getInstallURL(), pathSuffix);
		} catch (MalformedURLException e) {
			// do nothing
		}
	}
	
	// The plugin registry
	private final static ImageRegistry IMAGE_REGISTRY= new ImageRegistry();

	/*
	 * Available cached Images in the Java plugin image registry.
	 */	
	public static final String IMG_MISC_PUBLIC= NAME_PREFIX + "methpub_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_MISC_PROTECTED= NAME_PREFIX + "methpro_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_MISC_PRIVATE= NAME_PREFIX + "methpri_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_MISC_DEFAULT= NAME_PREFIX + "methdef_obj.gif"; 		//$NON-NLS-1$
	
	public static final String IMG_OBJS_GHOST= NAME_PREFIX + "ghost.gif"; 				//$NON-NLS-1$
	public static final String IMG_OBJS_SEARCH_TSK= NAME_PREFIX + "search_tsk.gif"; 		//$NON-NLS-1$
	public static final String IMG_OBJS_PACKDECL= NAME_PREFIX + "packd_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_IMPDECL= NAME_PREFIX + "imp_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_IMPCONT= NAME_PREFIX + "impc_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_JSEARCH= NAME_PREFIX + "jsearch_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_OBJS_SEARCH_DECL= NAME_PREFIX + "search_decl_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_SEARCH_REF= NAME_PREFIX + "search_ref_obj.gif"; 	//$NON-NLS-1$
	public static final String IMG_OBJS_CLASS= NAME_PREFIX + "class_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_CLASSALT= NAME_PREFIX + "classfo_obj.gif"; 			//$NON-NLS-1$	
	public static final String IMG_OBJS_PCLASS= NAME_PREFIX + "classp_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_INTERFACE= NAME_PREFIX + "int_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_INTERFACEALT= NAME_PREFIX + "intf_obj.gif"; 			//$NON-NLS-1$	
	public static final String IMG_OBJS_PINTERFACE= NAME_PREFIX + "intp_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_OBJS_CUNIT= NAME_PREFIX + "jcu_obj.gif"; 				//$NON-NLS-1$
	public static final String IMG_OBJS_CFILE= NAME_PREFIX + "classf_obj.gif";  			//$NON-NLS-1$
	public static final String IMG_OBJS_CFILECLASS= NAME_PREFIX + "class_obj.gif";  		//$NON-NLS-1$
	public static final String IMG_OBJS_CFILEINT= NAME_PREFIX + "int_obj.gif";  			//$NON-NLS-1$
	public static final String IMG_OBJS_PACKAGE= NAME_PREFIX + "package_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_OBJS_PACKFRAG_ROOT= NAME_PREFIX + "packagefolder_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_MISSING_PACKFRAG_ROOT= NAME_PREFIX + "packagefolder_nonexist_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_MISSING_JAR= NAME_PREFIX + "jar_nonexist_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_JAR= NAME_PREFIX + "jar_obj.gif"; 				//$NON-NLS-1$
	public static final String IMG_OBJS_EXTJAR= NAME_PREFIX + "jar_l_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_JAR_WSRC= NAME_PREFIX + "jar_src_obj.gif"; 		//$NON-NLS-1$
	public static final String IMG_OBJS_EXTJAR_WSRC= NAME_PREFIX + "jar_lsrc_obj.gif";	//$NON-NLS-1$
	public static final String IMG_OBJS_ENV_VAR= NAME_PREFIX + "envvar_obj.gif"; 			//$NON-NLS-1$
	public static final String IMG_OBJS_MISSING_ENV_VAR= NAME_PREFIX + "envvar_nonexist_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_JAVA_MODEL= NAME_PREFIX + "java_model_obj.gif"; //$NON-NLS-1$
	
	public static final String IMG_OBJS_LIBRARY= NAME_PREFIX + "library_obj.gif"; 		//$NON-NLS-1$
	
	public static final String IMG_OBJS_JAVADOCTAG= NAME_PREFIX + "jdoc_tag_obj.gif"; 	//$NON-NLS-1$
	public static final String IMG_OBJS_HTMLTAG= NAME_PREFIX + "html_tag_obj.gif"; 		//$NON-NLS-1$
	
	public static final String IMG_OBJS_TEMPLATE= NAME_PREFIX + "template_obj.gif"; 		//$NON-NLS-1$

	public static final String IMG_OBJS_EXCEPTION= NAME_PREFIX + "jexception_obj.gif"; 	//$NON-NLS-1$
	public static final String IMG_OBJS_ERROR= NAME_PREFIX + "jrtexception_obj.gif"; 		//$NON-NLS-1$
	
	public static final String IMG_OBJS_BREAKPOINT_INSTALLED= NAME_PREFIX + "brkpi_obj.gif"; //$NON-NLS-1$

	public static final String IMG_OBJS_SNIPPET_EVALUATING= NAME_PREFIX + "jsbook_run_obj.gif"; //$NON-NLS-1$

	public static final String IMG_OBJS_REFACTORING_FATAL= NAME_PREFIX + "fatalerror_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_REFACTORING_ERROR= NAME_PREFIX + "error_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_REFACTORING_WARNING= NAME_PREFIX + "warning_obj.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_REFACTORING_INFO= NAME_PREFIX + "info_obj.gif"; 	//$NON-NLS-1$

	/*
	 * Set of predefined Image Descriptors.
	 */
	private static final String T_OBJ= "obj16"; 		//$NON-NLS-1$
	private static final String T_OVR= "ovr16"; 		//$NON-NLS-1$
	private static final String T_WIZBAN= "wizban"; 	//$NON-NLS-1$
	private static final String T_LCL= "clcl16"; 	//$NON-NLS-1$
	private static final String T_CTOOL= "ctool16"; 	//$NON-NLS-1$

	public static final ImageDescriptor DESC_MISC_PUBLIC= createManaged(T_OBJ, IMG_MISC_PUBLIC);
	public static final ImageDescriptor DESC_MISC_PROTECTED= createManaged(T_OBJ, IMG_MISC_PROTECTED);
	public static final ImageDescriptor DESC_MISC_PRIVATE= createManaged(T_OBJ, IMG_MISC_PRIVATE);
	public static final ImageDescriptor DESC_MISC_DEFAULT= createManaged(T_OBJ, IMG_MISC_DEFAULT);
	
	public static final ImageDescriptor DESC_MENU_SHIFT_RIGHT= create(T_CTOOL, "shift_r_edit.gif"); 	//$NON-NLS-1$
	public static final ImageDescriptor DESC_MENU_SHIFT_LEFT= create(T_CTOOL, "shift_l_edit.gif"); 	//$NON-NLS-1$

	public static final ImageDescriptor DESC_OBJS_GHOST= createManaged(T_OBJ, IMG_OBJS_GHOST);
	public static final ImageDescriptor DESC_OBJS_PACKDECL= createManaged(T_OBJ, IMG_OBJS_PACKDECL);
	public static final ImageDescriptor DESC_OBJS_IMPDECL= createManaged(T_OBJ, IMG_OBJS_IMPDECL);
	public static final ImageDescriptor DESC_OBJS_IMPCONT= createManaged(T_OBJ, IMG_OBJS_IMPCONT);
	public static final ImageDescriptor DESC_OBJS_JSEARCH= createManaged(T_OBJ, IMG_OBJS_JSEARCH);
	public static final ImageDescriptor DESC_OBJS_SEARCH_DECL= createManaged(T_OBJ, IMG_OBJS_SEARCH_DECL);
	public static final ImageDescriptor DESC_OBJS_SEARCH_REF= createManaged(T_OBJ, IMG_OBJS_SEARCH_REF);
	public static final ImageDescriptor DESC_OBJS_CLASS= createManaged(T_OBJ, IMG_OBJS_CLASS);
	public static final ImageDescriptor DESC_OBJS_CLASSALT= createManaged(T_OBJ, IMG_OBJS_CLASSALT);
	public static final ImageDescriptor DESC_OBJS_PCLASS= createManaged(T_OBJ, IMG_OBJS_PCLASS);
	public static final ImageDescriptor DESC_OBJS_INTERFACE= createManaged(T_OBJ, IMG_OBJS_INTERFACE);
	public static final ImageDescriptor DESC_OBJS_INTERFACEALT= createManaged(T_OBJ, IMG_OBJS_INTERFACEALT);
	public static final ImageDescriptor DESC_OBJS_PINTERFACE= createManaged(T_OBJ, IMG_OBJS_PINTERFACE);
	public static final ImageDescriptor DESC_OBJS_CUNIT= createManaged(T_OBJ, IMG_OBJS_CUNIT);
	public static final ImageDescriptor DESC_OBJS_CFILE= createManaged(T_OBJ, IMG_OBJS_CFILE); 
	public static final ImageDescriptor DESC_OBJS_CFILECLASS= createManaged(T_OBJ, IMG_OBJS_CFILECLASS); 
	public static final ImageDescriptor DESC_OBJS_CFILEINT= createManaged(T_OBJ, IMG_OBJS_CFILEINT); 
	public static final ImageDescriptor DESC_OBJS_PACKAGE= createManaged(T_OBJ, IMG_OBJS_PACKAGE);
	public static final ImageDescriptor DESC_OBJS_PACKFRAG_ROOT= createManaged(T_OBJ, IMG_OBJS_PACKFRAG_ROOT);
	public static final ImageDescriptor DESC_OBJS_MISSING_PACKFRAG_ROOT= createManaged(T_OBJ, IMG_OBJS_MISSING_PACKFRAG_ROOT);
	public static final ImageDescriptor DESC_OBJS_JAVA_MODEL= createManaged(T_OBJ, IMG_OBJS_JAVA_MODEL);

	public static final ImageDescriptor DESC_OBJS_JAR= createManaged(T_OBJ, IMG_OBJS_JAR);
	public static final ImageDescriptor DESC_OBJS_MISSING_JAR= createManaged(T_OBJ, IMG_OBJS_MISSING_JAR);
	public static final ImageDescriptor DESC_OBJS_EXTJAR= createManaged(T_OBJ, IMG_OBJS_EXTJAR);
	public static final ImageDescriptor DESC_OBJS_JAR_WSRC= createManaged(T_OBJ, IMG_OBJS_JAR_WSRC);
	public static final ImageDescriptor DESC_OBJS_EXTJAR_WSRC= createManaged(T_OBJ, IMG_OBJS_EXTJAR_WSRC);
	public static final ImageDescriptor DESC_OBJS_ENV_VAR= createManaged(T_OBJ, IMG_OBJS_ENV_VAR);
	public static final ImageDescriptor DESC_OBJS_MISSING_ENV_VAR= createManaged(T_OBJ, IMG_OBJS_MISSING_ENV_VAR);
	
	public static final ImageDescriptor DESC_OBJS_LIBRARY= createManaged(T_OBJ, IMG_OBJS_LIBRARY);
	
	public static final ImageDescriptor DESC_OBJS_JAVADOCTAG= createManaged(T_OBJ, IMG_OBJS_JAVADOCTAG);
	public static final ImageDescriptor DESC_OBJS_HTMLTAG= createManaged(T_OBJ, IMG_OBJS_HTMLTAG);

	public static final ImageDescriptor DESC_OBJS_TEMPLATE= createManaged(T_OBJ, IMG_OBJS_TEMPLATE);
	
	public static final ImageDescriptor DESC_OBJS_EXCEPTION= createManaged(T_OBJ, IMG_OBJS_EXCEPTION);
	public static final ImageDescriptor DESC_OBJS_BREAKPOINT_INSTALLED= createManaged(T_OBJ, IMG_OBJS_BREAKPOINT_INSTALLED);
	public static final ImageDescriptor DESC_OBJS_ERROR= createManaged(T_OBJ, IMG_OBJS_ERROR);
	
	public static final ImageDescriptor DESC_OBJS_SNIPPET_EVALUATING= createManaged(T_OBJ, IMG_OBJS_SNIPPET_EVALUATING);
	
	public static final ImageDescriptor DESC_OBJS_DEFAULT_CHANGE= create(T_OBJ, "change.gif");
	public static final ImageDescriptor DESC_OBJS_COMPOSITE_CHANGE= create(T_OBJ, "composite_change.gif");
	public static final ImageDescriptor DESC_OBJS_CU_CHANGE= create(T_OBJ, "cu_change.gif");
	public static final ImageDescriptor DESC_OBJS_FILE_CHANGE= create(T_OBJ, "file_change.gif");
	public static final ImageDescriptor DESC_OBJS_TEXT_EDIT= create(T_OBJ, "text_edit.gif");

	public static final ImageDescriptor DESC_OBJS_REFACTORING_FATAL= createManaged(T_OBJ, IMG_OBJS_REFACTORING_FATAL);
	public static final ImageDescriptor DESC_OBJS_REFACTORING_ERROR= createManaged(T_OBJ, IMG_OBJS_REFACTORING_ERROR);
	public static final ImageDescriptor DESC_OBJS_REFACTORING_WARNING= createManaged(T_OBJ, IMG_OBJS_REFACTORING_WARNING);
	public static final ImageDescriptor DESC_OBJS_REFACTORING_INFO= createManaged(T_OBJ, IMG_OBJS_REFACTORING_INFO);

	public static final ImageDescriptor DESC_OVR_STATIC= create(T_OVR, "static_co.gif"); 						//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_FINAL= create(T_OVR, "final_co.gif"); 						//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_ABSTRACT= create(T_OVR, "abstract_co.gif"); 					//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_SYNCH= create(T_OVR, "synch_co.gif"); 						//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_RUN= create(T_OVR, "run_co.gif"); 							//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_WARNING= create(T_OVR, "warning_co.gif"); 					//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_ERROR= create(T_OVR, "error_co.gif"); 						//$NON-NLS-1$
	public static final ImageDescriptor DESC_OVR_OVERRIDDEN= create(T_OVR, "over_co.gif");  						//$NON-NLS-1$
		
	public static final ImageDescriptor DESC_WIZBAN_NEWCLASS= create(T_WIZBAN, "newclass_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWFIELD= create(T_WIZBAN, "newfield_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWINT= create(T_WIZBAN, "newint_wiz.gif"); 				//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWJPRJ= create(T_WIZBAN, "newjprj_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWSRCFOLDR= create(T_WIZBAN, "newsrcfldr_wiz.gif"); 		//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWMETH= create(T_WIZBAN, "newmeth_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWPACK= create(T_WIZBAN, "newpack_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_NEWSCRAPPAGE= create(T_WIZBAN, "newsbook_wiz.gif");		//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_JAVA_LAUNCH= create(T_WIZBAN, "java_app_wiz.gif"); 		//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_JAVA_ATTACH= create(T_WIZBAN, "java_attach_wiz.gif"); 	//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR= create(T_WIZBAN, "refactor_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR_METHOD= create(T_WIZBAN, "methrefact_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR_TYPE= create(T_WIZBAN, "typerefact_wiz.gif"); 	//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR_PACKAGE= create(T_WIZBAN, "packrefact_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR_CODE= create(T_WIZBAN, "coderefact_wiz.gif"); 	//$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_REFACTOR_CU= create(T_WIZBAN, "compunitrefact_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_WIZBAN_JAR_PACKAGER= create(T_WIZBAN, "jar_pack_wiz.gif"); 		//$NON-NLS-1$
	
	public static final ImageDescriptor DESC_TOOL_DISPLAYSNIPPET= create(T_CTOOL, "disp_sbook.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_RUNSNIPPET= create(T_CTOOL, "run_sbook.gif"); 				//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_INSPSNIPPET= create(T_CTOOL, "insp_sbook.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_PACKSNIPPET= create(T_CTOOL, "pack_sbook.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_TERMSNIPPET= create(T_CTOOL, "term_sbook.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_SHOW_EMPTY_PKG= create(T_CTOOL, "show_empty_pkg.gif"); 		//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_SHOW_SEGMENTS= create(T_CTOOL, "segment_edit.gif"); 		//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_GOTO_NEXT_ERROR= create(T_CTOOL, "next_error_nav.gif"); 	//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_GOTO_PREV_ERROR= create(T_CTOOL, "prev_error_nav.gif"); 	//$NON-NLS-1$

	public static final ImageDescriptor DESC_TOOL_OPENTYPE= create(T_CTOOL, "opentype.gif"); 					//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWPROJECT= create(T_CTOOL, "newjprj_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWPACKAGE= create(T_CTOOL, "newpack_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWCLASS= create(T_CTOOL, "newclass_wiz.gif"); 				//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWINTERFACE= create(T_CTOOL, "newint_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWSNIPPET= create(T_CTOOL, "newsbook_wiz.gif"); 			//$NON-NLS-1$
	public static final ImageDescriptor DESC_TOOL_NEWPACKROOT= create(T_CTOOL, "newpackfolder_wiz.gif"); 		//$NON-NLS-1$

	public static final ImageDescriptor DESC_TOOL_CLASSPATH_ORDER= create(T_OBJ, "cp_order_obj.gif"); 		//$NON-NLS-1$

	/**
	 * Returns the image managed under the given key in this registry.
	 * 
	 * @param key the image's key
	 * @return the image managed under the given key
	 */ 
	public static Image get(String key) {
		return IMAGE_REGISTRY.get(key);
	}
	
	/**
	 * Sets the three image descriptors for enabled, disabled, and hovered to an action. The actions
	 * are retrieved from the *tool16 folders.
	 */
	public static void setToolImageDescriptors(IAction action, String iconName) {
		setImageDescriptors(action, "tool16", iconName);
	}
	
	/**
	 * Sets the three image descriptors for enabled, disabled, and hovered to an action. The actions
	 * are retrieved from the *lcl16 folders.
	 */
	public static void setLocalImageDescriptors(IAction action, String iconName) {
		setImageDescriptors(action, "lcl16", iconName);
	}
	
	/*
	 * Helper method to access the image registry from the JavaPlugin class.
	 */
	/* package */ static ImageRegistry getImageRegistry() {
		return IMAGE_REGISTRY;
	}

	//---- Helper methods to access icons on the file system --------------------------------------

	private static void setImageDescriptors(IAction action, String type, String relPath) {
		
		try {
			ImageDescriptor id= ImageDescriptor.createFromURL(makeIconFileURL("d" + type, relPath)); //$NON-NLS-1$
			if (id != null)
				action.setDisabledImageDescriptor(id);
		} catch (MalformedURLException e) {
		}
	
		try {
			ImageDescriptor id= ImageDescriptor.createFromURL(makeIconFileURL("c" + type, relPath)); //$NON-NLS-1$
			if (id != null)
				action.setHoverImageDescriptor(id);
		} catch (MalformedURLException e) {
		}
	
		action.setImageDescriptor(create("e" + type, relPath)); //$NON-NLS-1$
	}
	
	private static ImageDescriptor createManaged(String prefix, String name) {
		try {
			ImageDescriptor result= ImageDescriptor.createFromURL(makeIconFileURL(prefix, name.substring(NAME_PREFIX_LENGTH)));
			IMAGE_REGISTRY.put(name, result);
			return result;
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	private static ImageDescriptor create(String prefix, String name) {
		try {
			return ImageDescriptor.createFromURL(makeIconFileURL(prefix, name));
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	private static URL makeIconFileURL(String prefix, String name) throws MalformedURLException {
		if (fgIconBaseURL == null)
			throw new MalformedURLException();
			
		StringBuffer buffer= new StringBuffer(prefix);
		buffer.append('/');
		buffer.append(name);
		return new URL(fgIconBaseURL, buffer.toString());
	}	
}
