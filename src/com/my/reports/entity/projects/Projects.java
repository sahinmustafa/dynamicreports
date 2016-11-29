/**
 * 
 */
package com.my.reports.entity.projects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
