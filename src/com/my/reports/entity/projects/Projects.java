/**
 * 
 */
package com.my.reports.entity.projects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.my.reports.base.dao.definitions.IBaseDao;
import com.my.reports.base.entity.BaseEntity;
import com.my.reports.entity.reports.ReportTemplate;

/**
 * @author MustafaS.
 *
 */
@Entity
@Table(name="PROJECTS")
public class Projects extends BaseEntity{

	private static final long serialVersionUID = 1517308247417688318L;
	
	@Column(name="PROJECT_NAME", nullable=false)
	private String projectName;
	
	@Transient
	private DatabaseSettings databaseSettings;
	
	@Transient
	private List<ReportTemplate> reportTemplate;
	
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
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public DatabaseSettings getDatabaseSettings() {
		return databaseSettings;
	}
	public void setDatabaseSettings(DatabaseSettings databaseSettings) {
		this.databaseSettings = databaseSettings;
	}
	public List<ReportTemplate> getReportTemplate() {
		return reportTemplate;
	}
	public void setReportTemplate(List<ReportTemplate> reportTemplate) {
		this.reportTemplate = reportTemplate;
	}
	
	

}
