/**
 * 
 */
package com.my.reports.service.projects.definitions;

import org.json.JSONObject;

import com.my.reports.entity.projects.Projects;

/**
 * @author MustafaS.
 *
 */
public interface IProjectsService {

	public JSONObject saveProjects(Projects projects);
	public JSONObject updateProjects(Projects projects);
	public JSONObject deleteProjects(String projectsID);
	public JSONObject listProjects(JSONObject params);
}
