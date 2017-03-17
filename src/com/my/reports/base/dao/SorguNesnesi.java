/**
 * 
 */
package com.my.reports.base.dao;

import java.util.HashMap;
import java.util.Map;

import com.my.reports.base.entity.BaseEntity;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
public class SorguNesnesi<T extends BaseEntity> {

	private String sqlSelect;
	private StringBuilder sqlFrom;
	private String alias;
	private StringBuilder where;
	private boolean isCount;
	private String countColumn;
	private String orderBy;
	private Map<String, Object> parameterList;

	public SorguNesnesi() {
	}

	public SorguNesnesi(Class<T> clazz, String alias) {
		this.alias = alias;
		
		this.sqlFrom =new StringBuilder(" from ")
			.append(clazz.getSimpleName())
			.append(" ")
			.append(alias);
		
	}
	
	public SorguNesnesi(Class<T> clazz, String alias, String orderBy){
		this(clazz, alias);
		this.orderBy = orderBy;
	}
	
	
	public SorguNesnesi(Class<T> clazz, String alias, boolean isCount, String countColumn) {
		this(clazz, alias);
		this.isCount = isCount;
		this.countColumn = DataUtility.isNullOrEmpty(countColumn) ? "oid" : countColumn;		
	}
	
	public SorguNesnesi<T> sorguyaKriterEkle(Object clauseValue, String clause, String paramKey) throws Exception{
		if(DataUtility.isNull(clauseValue))
			return this;
		
		DataUtility.isNullOrEmpty(clause, true, "Clause değeri null olamaz!");
		DataUtility.isNullOrEmpty(paramKey, true, "paramKey değeri null olamaz!");
		
		if(DataUtility.isNull(where))
			where = new StringBuilder(" where ");
		
		where
			.append(" ")
			.append(clause)
			.append(" ")
			.append(":")
			.append(paramKey);
		
		if(DataUtility.isNull(parameterList))
			parameterList = new HashMap<String, Object>();
		
		parameterList.put(paramKey, clauseValue);
		
		return this;
	}
	
	public String getHQL() throws Exception{
		DataUtility.isNull(this.sqlFrom, true, "SQL From null olamaz!");
		DataUtility.isNullOrEmpty(this.alias, true, "Alias null olamaz!");
		
		if(!DataUtility.isNull(this.where))
			this.sqlFrom.append(" ").append(this.where);
		
		if(!DataUtility.isNullOrEmpty(this.orderBy))
			this.sqlFrom.append(" ").append(this.orderBy);
		
		return this.sqlFrom.toString();
	}

	public String getSqlSelect() {
		return sqlSelect;
	}

	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}

	public StringBuilder getSqlForm() {
		return sqlFrom;
	}

	public void setSqlForm(StringBuilder sqlForm) {
		this.sqlFrom = sqlForm;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public StringBuilder getWhere() {
		return where;
	}

	public void setWhere(StringBuilder where) {
		this.where = where;
	}

	public boolean isCount() {
		return isCount;
	}

	public void setCount(boolean isCount) {
		this.isCount = isCount;
	}

	public String getCountColumn() {
		return countColumn;
	}

	public void setCountColumn(String countColumn) {
		this.countColumn = countColumn;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Map<String, Object> getParameterList() {
		return parameterList;
	}

	public void setParameterList(Map<String, Object> parameterList) {
		this.parameterList = parameterList;
	}
	
	
}
