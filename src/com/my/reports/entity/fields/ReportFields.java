/**
 * 
 */
package com.my.reports.entity.fields;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.enums.FieldType;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
@MappedSuperclass
public abstract class ReportFields extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="REPORT_OID", nullable=false, length=EntityUtility.OID_UZUNLUGU)
	private String reportOid;
	
	@Column(name="NAME", nullable=false, length=EntityUtility.TEXT_ALAN_UZUNLUGU)
	private String name;
	
	@Column(name="TITLE", nullable=true, length=EntityUtility.UZUN_TEXT_ALAN_UZUNLUGU)
	private String title;
	
	@Type(type = "com.my.reports.utility.EnumUserType", parameters = @Parameter(name = "type", value = "com.my.reports.base.enums.FieldType"))
	@Column(name="FIELD_TYPE", length=EntityUtility.KOD_ALAN_UZUNLUGU, nullable=false)
	private FieldType fieldType;
	
	@Column(name="ORDER", nullable=false, length=EntityUtility.YIL_ALAN_UZUNLUGU)
	private int order;
	
	@Column(name="REF_DATA", nullable=true, length=EntityUtility.TEXT_ALAN_UZUNLUGU)
	private String refData;

	
	
	public String getReportOid() {
		return reportOid;
	}

	public void setReportOid(String reportOid) {
		this.reportOid = reportOid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getRefData() {
		return refData;
	}

	public void setRefData(String refData) {
		this.refData = refData;
	}
	
	

}
