/**
 * 
 */
package com.my.reports.service.projects.definitions;

import org.json.JSONObject;

import com.my.reports.base.entity.ServiceResult;
import com.my.reports.entity.projects.Projects;

/**
 * @author MustafaS.
 *
 */
public interface IProjectsService {

	public ServiceResult saveProjects(Projects projects) throws Exception;
	public ServiceResult updateProjects(Projects projects) throws Exception;
	public ServiceResult deleteProjects(String projectsID) throws Exception;
	public ServiceResult listProjects(JSONObject params) throws Exception;
}
