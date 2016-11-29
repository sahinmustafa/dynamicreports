/**
 * 
 */
package com.my.reports.utility;

/**
 * @author MustafaS.
 *
 */
public class DataUtility {

	
	public static boolean isNullOrEmpty(String s){
		return s != null ? s.length() == 0 : true; 
	}
	
	public static String upperCaseFirstChar(String s){
		if(isNullOrEmpty(s))
			return s;
		
		char firstChar = Character.toUpperCase(s.charAt(0));
		return firstChar + s.substring(1);
	}
}
