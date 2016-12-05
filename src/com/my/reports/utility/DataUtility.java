/**
 * 
 */
package com.my.reports.utility;

import java.util.List;

/**
 * @author MustafaS.
 *
 */
public class DataUtility {

	
	public static boolean isNullOrEmpty(String s){
		return s != null ? s.length() == 0 : true; 
	}
	
	public static boolean isNullOrEmpty(String s, boolean throwable) throws Exception{
		return isNullOrEmpty(s, throwable, "Boş değer");
	}
	
	public static boolean isNullOrEmpty(String s, boolean throwable, String message) throws Exception{
		if(throwable && isNullOrEmpty(s))
			throw new Exception(message);
		
		return isNullOrEmpty(s);
	}
	
	public static boolean isNullOrEmpty(List<?> list){
		return list != null ? list.size() == 0 : true;
	}
	
	public static String upperCaseFirstChar(String s){
		if(isNullOrEmpty(s))
			return s;
		
		char firstChar = Character.toUpperCase(s.charAt(0));
		return firstChar + s.substring(1);
	}
}
