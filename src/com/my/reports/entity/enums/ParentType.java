/**
 * 
 */
package com.my.reports.entity.enums;

import com.my.reports.base.enums.definitions.INumericEnumType;

/**
 * @author MustafaS.
 *
 */
public enum ParentType implements INumericEnumType{
	REPORT(1, "Rapor"),
	REPORT_TITLE(2, "Rapor Başlık"),
	COLUMN_HEADER(3, "Kolon Başlık"),
	COLUMN_DETAIL(4, "Kolon Detay");

	private int code;
	private String value;
	
	private ParentType(int code, String value) {
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

}
