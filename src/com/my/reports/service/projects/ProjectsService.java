/**
 * 
 */
package com.my.reports.service.projects;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.my.reports.base.entity.ServiceResult;
import com.my.reports.base.service.BaseService;
import com.my.reports.entity.projects.Projects;
import com.my.reports.service.projects.definitions.IProjectsService;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
@Service
public class ProjectsService extends BaseService implements IProjectsService{

	@Override
	public ServiceResult saveProjects(Projects projects) throws Exception {
		System.out.println("saveProjects");
		
		if(DataUtility.isNull(projects))
			return null;
		
		
		projects.entityKaydet(null, dao);
		
		ServiceResult result = new ServiceResult(projects, "Proje Bilgileri Başarı ile kayıt edildi!");
		return result;
	}

	@Override
	public ServiceResult updateProjects(Projects projects) {
		System.out.println("updateProjects");
		return null;
	}

	@Override
	public ServiceResult deleteProjects(String projectsID) {
		System.out.println("deleteProjects");
		return null;
	}

	@Override
	public ServiceResult listProjects(JSONObject params) {
		System.out.println("listProjects");
		return null;
	}

}
