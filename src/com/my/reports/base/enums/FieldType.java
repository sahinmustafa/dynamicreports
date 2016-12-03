/**
 * 
 */
package com.my.reports.base.enums;

/**
 * @author MustafaS.
 *
 */
public enum FieldType implements INumericEnumType{
	INTEGER(1, "Tam Sayı"),
	STRING(2, "Metin"),
	BOOLEAN(3, "Evet/Hayır"),
	DATE(4, "Tarih"),
	DATETIME(5, "Tarih Saat"),
	DECIMAL(6, "Virgüllü Sayı"),
	COMBO(7, "Referans");

	
	private int code;
	private String value;
	
	
	private FieldType(int code, String value) {
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
