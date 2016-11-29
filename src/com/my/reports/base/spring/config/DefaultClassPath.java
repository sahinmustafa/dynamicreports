/**
 * 
 */
package com.my.reports.base.spring.config;

/**
 * @author MustafaS.
 *
 */
public class DefaultClassPath {

	public final static String BASE_PATH = "com.my.reports.base";
	public final static String CONTROLLER_PATH = "com.my.reports.base.controller";
	public final static String SERVICE_PATH = "com.my.reports.service";
	public final static String ENTITY_PATH = "com.my.reports.entity";
	
	
	public static String getSimpleClassName(String fullName){
		return fullName.substring(fullName.lastIndexOf(".")+1);
	}
}
