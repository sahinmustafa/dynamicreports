/**
 * 
 */
package com.my.reports.entity.fields;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
@Entity
@Table(name="SEARCH_FIELD")
public class SearchField extends ReportFields{

	private static final long serialVersionUID = -456482301115353369L;

	@Column(name="IS_REQUIRED", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isRequired;
	
	@Column(name="IS_BETWEEN", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isBetween;
	
	@Column(name="DEFAULT_VALUE", nullable=true, length=EntityUtility.TEXT_ALAN_UZUNLUGU)
	private String defaultValue;

	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entityKaydet(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entityKaydet(BaseEntity parent, IBaseDao dao) {
		this.setReportOid(parent.getOid());
		dao.save(this);
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
	
	public int getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(int isRequired) {
		this.isRequired = isRequired;
	}

	public int getIsBetween() {
		return isBetween;
	}

	public void setIsBetween(int isBetween) {
		this.isBetween = isBetween;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
}
