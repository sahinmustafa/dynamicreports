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
public enum FieldType implements INumericEnumType, IParameters{
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

	@Override
	public String getKey() {
		return this.getCode() + "";
	}

	@Override
	public String getText() {
		return this.getText();
	}

	@Override
	public Map<String, Object> extraParams() {
		// TODO Auto-generated method stub
		return null;
	}

}
