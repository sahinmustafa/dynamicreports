/**
 * 
 */
package com.my.reports.entity.reports;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.enums.ParentType;
import com.my.reports.entity.fields.ColumnField;
import com.my.reports.entity.fields.SearchField;
import com.my.reports.utility.DataUtility;
import com.my.reports.utility.EntityUtility;

/**
 * @author MustafaS.
 *
 */
public class ReportTemplate extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="REPORT_TITLE", nullable=false, length=EntityUtility.UZUN_TEXT_ALAN_UZUNLUGU)
	private String reportTitle;
	
	@Column(name="IS_ZEBRA", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isZebra;
	
	@Column(name="IS_LANDSPACE", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isLandspace;
	
	@Column(name="IS_ROW_NUMBER", nullable=false, length=EntityUtility.BOOLEAN_ALAN_UZUNLUGU)
	private int isRowNumber;
	
	@Transient private List<SearchField> searchFields;
	@Transient private List<ColumnField> columns;
	@Transient private ReportFontStyle titleFontStyle;
	
	/* (non-Javadoc)
	 * @see com.my.reports.base.entity.BaseEntity#entityKaydet(com.my.reports.base.entity.BaseEntity, com.my.reports.base.dao.definitions.IBaseDao)
	 */
	@Override
	public void entityKaydet(BaseEntity parent, IBaseDao dao) {
		dao.save(this);
		
		if(!DataUtility.isNullOrEmpty(this.getSearchFields()))
			for(SearchField searcField : searchFields)
				searcField.entityKaydet(this, dao);
		if(!DataUtility.isNullOrEmpty(columns))
			for(ColumnField column : columns)
				column.entityKaydet(this, dao);
		
		if(titleFontStyle != null)
			titleFontStyle.entityKaydet(this, dao);
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
	
	
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public int getIsZebra() {
		return isZebra;
	}
	public void setIsZebra(int isZebra) {
		this.isZebra = isZebra;
	}
	public int getIsLandspace() {
		return isLandspace;
	}
	public void setIsLandspace(int isLandspace) {
		this.isLandspace = isLandspace;
	}
	public int getIsRowNumber() {
		return isRowNumber;
	}
	public void setIsRowNumber(int isRowNumber) {
		this.isRowNumber = isRowNumber;
	}
	public List<SearchField> getSearchFields() {
		return searchFields;
	}
	public void setSearchFields(List<SearchField> searchFields) {
		this.searchFields = searchFields;
	}
	public List<ColumnField> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnField> columns) {
		this.columns = columns;
	}
	public ReportFontStyle getTitleFontStyle() {
		return titleFontStyle;
	}
	public void setTitleFontStyle(ReportFontStyle titleFontStyle) {
		if(titleFontStyle != null)
			titleFontStyle.setParentType(ParentType.REPORT_TITLE);
		this.titleFontStyle = titleFontStyle;
	}
	
	
	
}
