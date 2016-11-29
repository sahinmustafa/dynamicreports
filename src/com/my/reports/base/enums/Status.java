/**
 * 
 */
package com.my.reports.base.enums;

/**
 * @author MustafaS.
 *
 */
public enum Status implements INumericEnumType {
	AKTIF(1,"Aktif"),
	PASIF(0, "Pasif");

	
	private int code;
	private String value;
	
	private Status(int code, String value) {
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
