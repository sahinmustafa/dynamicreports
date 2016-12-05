/**
 * 
 */
package com.my.reports.entity.reports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.entity.enums.ParentType;
import com.my.reports.entity.enums.ReportFontTypes;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
@Entity
@Table(name="REPORT_FONT_STYLE")
public class ReportFontStyle extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="PARENT_OID", nullable=false, length=EntityUtility.OID_UZUNLUGU)
	private String reportOid;
	
	@Type(type = "com.my.reports.utility.EnumUserType", parameters = @Parameter(name = "type", value = "com.my.reports.base.enums.ParentType"))
	@Column(name="PARENT_TYPE", length=EntityUtility.KOD_ALAN_UZUNLUGU, nullable=false)
	private ParentType parentType;
	
	@Type(type = "com.my.reports.utility.EnumUserType", parameters = @Parameter(name = "type", value = "com.my.reports.base.enums.ReportFontTypes"))
	@Column(name="FONT_TYPE", length=EntityUtility.KOD_ALAN_UZUNLUGU, nullable=false)
	private ReportFontTypes fontType;
	
	@Column(name="FONT_SIZE", nullable=false, length=EntityUtility.YIL_ALAN_UZUNLUGU)
	private int fontSize;
	
	@Column(name="IS_BOLDE", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isBold;
	
	@Column(name="IS_UNDERLINE", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isUnderline;
	
	@Column(name="IS_ITALIC", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isItalic;

	
	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entityKaydet(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entityKaydet(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entityGuncelle(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entityGuncelle(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entitySil(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entitySil(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#altSinifGetir(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void altSinifGetir(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#ustSinifGetir(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void ustSinifGetir(BaseEntity parent, IBaseDao dao) {
		// TODO Auto-generated method stub
		
	}
	
	public String getReportOid() {
		return reportOid;
	}

	public void setReportOid(String reportOid) {
		this.reportOid = reportOid;
	}

	public ParentType getParentType() {
		return parentType;
	}

	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}

	public ReportFontTypes getFontType() {
		return fontType;
	}

	public void setFontType(ReportFontTypes fontType) {
		this.fontType = fontType;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getIsBold() {
		return isBold;
	}

	public void setIsBold(int isBold) {
		this.isBold = isBold;
	}

	public int getIsUnderline() {
		return isUnderline;
	}

	public void setIsUnderline(int isUnderline) {
		this.isUnderline = isUnderline;
	}

	public int getIsItalic() {
		return isItalic;
	}

	public void setIsItalic(int isItalic) {
		this.isItalic = isItalic;
	}
	
	
	

}
