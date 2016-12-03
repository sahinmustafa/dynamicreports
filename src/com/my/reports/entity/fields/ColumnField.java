/**
 * 
 */
package com.my.reports.entity.fields;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.enums.ParentType;
import com.my.reports.entity.reports.ReportFontStyle;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
@Entity
@Table(name="COLUMN_FIELD")
public class ColumnField extends ReportFields{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name="IS_INCLUDED", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isIncluded;
	
	@Column(name="IS_VISIBLE", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isVisible;
	
	@Column(name="WIDTH", nullable=false, length=EntityUtility.YIL_ALAN_UZUNLUGU)
	private int width;
	
	@Column(name="IS_GROUPBY", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isGroupBy;
	
	@Column(name="IS_GROUP_TOTAL", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isGroupTotal;
	
	@Column(name="IS_SUB_TOTAL", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isSubTotal;
	
	@Transient private ReportFontStyle columnHeaderStyle;
	@Transient private ReportFontStyle columnDetailStyle;


	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entityKaydet(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entityKaydet(BaseEntity parent, IBaseDao dao) {
		this.setReportOid(parent.getOid());
		dao.save(this);
		
		if(columnDetailStyle != null)
			columnDetailStyle.entityKaydet(this, dao);
		
		if(columnHeaderStyle != null)
			columnHeaderStyle.entityKaydet(this, dao);
		
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

	public int getIsIncluded() {
		return isIncluded;
	}

	public void setIsIncluded(int isIncluded) {
		this.isIncluded = isIncluded;
	}

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getIsGroupBy() {
		return isGroupBy;
	}

	public void setIsGroupBy(int isGroupBy) {
		this.isGroupBy = isGroupBy;
	}

	public int getIsGroupTotal() {
		return isGroupTotal;
	}

	public void setIsGroupTotal(int isGroupTotal) {
		this.isGroupTotal = isGroupTotal;
	}

	public int getIsSubTotal() {
		return isSubTotal;
	}

	public void setIsSubTotal(int isSubTotal) {
		this.isSubTotal = isSubTotal;
	}

	public ReportFontStyle getColumnHeaderStyle() {
		return columnHeaderStyle;
	}

	public void setColumnHeaderStyle(ReportFontStyle columnHeaderStyle) {
		if(columnHeaderStyle != null)
			columnHeaderStyle.setParentType(ParentType.COLUMN_HEADER);
		this.columnHeaderStyle = columnHeaderStyle;
	}

	public ReportFontStyle getColumnDetailStyle() {
		return columnDetailStyle;
	}

	public void setColumnDetailStyle(ReportFontStyle columnDetailStyle) {
		if(columnHeaderStyle != null)
			columnHeaderStyle.setParentType(ParentType.COLUMN_DETAIL);
		this.columnDetailStyle = columnDetailStyle;
	}
	
}
