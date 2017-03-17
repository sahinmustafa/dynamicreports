/**
 * 
 */
package com.my.reports.base.enums.definitions;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * @author MustafaS.
 *
 */
public interface INumericEnumType {

	@JsonValue
	public int getCode();
	public String value();
	
	public default <T extends INumericEnumType> T getFromValue(Class<T> clazz, String value){
		for(T t : clazz.getEnumConstants())
			if(t.value().equals(value))
				return t;
		return null;
	}
	
	public default <T extends INumericEnumType> T getFromCode(Class<T> clazz, int code){
		for(T t : clazz.getEnumConstants())
			if(t.getCode() == code)
				return t;
		return null;
	}
}
