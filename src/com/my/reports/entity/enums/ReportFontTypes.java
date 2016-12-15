/**
 * 
 */
package com.my.reports.entity.enums;

import java.util.Map;

import com.my.reports.base.entity.definitions.IParameters;
import com.my.reports.base.enums.definitions.INumericEnumType;

/**
 * @author MustafaS.
 *
 */
public enum ReportFontTypes implements INumericEnumType, IParameters{
	ARIAL(1, "Arial"),
	TIMES_NEW_ROMAN(2, "Times New Roman"),
	COMIC_SANS(3, "Comic Sans");

	private int code;
	private String value;
	
	private ReportFontTypes(int code, String value) {
		this.code = code;
		this.value = value;
	}
	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String value() {
		return this.value;
	}
	
	@Override
	public String getKey() {
		return this.getCode() + "";
	}
	
	@Override
	public String getText() {
		return this.value;
	}
	
	@Override
	public Map<String, Object> extraParams() {
		// TODO Auto-generated method stub
		return null;
	}

}
