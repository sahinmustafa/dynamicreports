/**
 * 
 */
package com.my.reports.entity.enums;

import com.my.reports.base.enums.definitions.INumericEnumType;

/**
 * @author MustafaS.
 *
 */
public enum ReportFontTypes implements INumericEnumType{
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

}
