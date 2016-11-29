/**
 * 
 */
package com.my.reports.service.projects;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.my.reports.base.service.BaseService;
import com.my.reports.entity.projects.Projects;
import com.my.reports.service.projects.definitions.IProjectsService;

/**
 * @author MustafaS.
 *
 */
@Service
public class ProjectsService extends BaseService implements IProjectsService{

	@Override
	public JSONObject saveProjects(Projects projects) {
		System.out.println("saveProjects");
		return null;
	}

	@Override
	public JSONObject updateProjects(Projects projects) {
		System.out.println("updateProjects");
		return null;
	}

	@Override
	public JSONObject deleteProjects(String projectsID) {
		System.out.println("deleteProjects");
		return null;
	}

	@Override
	public JSONObject listProjects(JSONObject params) {
		System.out.println("listProjects");
		return null;
	}

}
