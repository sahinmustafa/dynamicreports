/**
 * 
 */
package com.my.reports.base.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.my.reports.base.entity.ServiceResult;
import com.my.reports.base.entity.definitions.IParameters;
import com.my.reports.base.enums.definitions.IReferenceData;
import com.my.reports.base.spring.ApplicationStartupListener;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
@Service
public class ReferenceDataService extends BaseService {

	//@Autowired private BaseController serviceCaller;
	

	public ServiceResult fillRefData(String refData) throws Exception {
		DataUtility.isNullOrEmpty(refData, true, "Referens Data değeri boş olamaz!");

		IReferenceData ref = ApplicationStartupListener.getReferenceDataFromRefData(refData);
		Class<? extends IParameters> clazz = ref.getClazz();

		JSONArray arr = new JSONArray();
		if (clazz.isEnum()) {
			for (IParameters p : clazz.getEnumConstants()) {
				JSONObject object = new JSONObject();
				object.put("key", p.getKey());
				object.put("text", p.getText());
				object.put("extraParams", p.extraParams());
				
				arr.put(object);
			}
			ServiceResult result = new ServiceResult(arr);
			return result;
		} else {
			JSONObject params = new JSONObject();
			params.put("clazz", ref.getClazz());
			return null; //serviceCaller.callService(ref.getServiceName(), params);
		}
	}

	public JSONObject defaultParametre(String refData, Class<? extends IParameters> clazz){
		// TODO Nesne sorgulama yazılacak
		return null;
	}


}
