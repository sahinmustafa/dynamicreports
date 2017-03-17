/**
 * 
 */
package com.my.reports.service.reports;

import com.my.reports.base.entity.ServiceResult;
import com.my.reports.base.service.BaseService;
import com.my.reports.entity.reports.ReportTemplate;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
public class ReportService extends BaseService{

	public ServiceResult raporKaydet(ReportTemplate template) throws Exception{
		if(template == null)
			return null;
		
		if(DataUtility.isNullOrEmpty(template.getReportTitle() ))
			throw new Exception("Rapor Başlığı boş olamaz!");
		
		template.entityKaydet(null, dao);
		
		
		return null;
	}
	
}
