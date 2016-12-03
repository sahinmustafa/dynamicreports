/**
 * 
 */
package com.my.reports.service.reports;

import org.json.JSONObject;

import com.my.reports.base.service.BaseService;
import com.my.reports.entity.reports.ReportTemplate;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
public class ReportService extends BaseService{

	public JSONObject raporKaydet(ReportTemplate template) throws Exception{
		if(template == null)
			return null;
		
		if(DataUtility.isNullOrEmpty(template.getReportTitle() ))
			throw new Exception("Rapor Başlığı boş olamaz!");
		
		template.entityKaydet(null, dao);
		
		
		return null;
	}
}
