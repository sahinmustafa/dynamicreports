/**
 * 
 */
package com.my.reports.base.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.reports.base.controller.BaseController;
import com.my.reports.base.entity.definitions.IParameters;
import com.my.reports.base.enums.ReferenceData;
import com.my.reports.base.utility.ParametreUtil;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
@Service
public class ReferenceDataService extends BaseService {

	@Autowired private BaseController serviceCaller;
	
	private static Map<String, ReferenceData> params = null;

	public JSONObject fillRefData(String refData) throws Exception {
		DataUtility.isNullOrEmpty(refData, true, "Referens Data değeri boş olamaz!");

		ReferenceData ref = ReferenceDataService.params.get(refData);
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
			JSONObject result = new JSONObject();
			result.put("data", arr);
			return result;
		} else {
			JSONObject params = new JSONObject();
			params.put("clazz", ref.getClazz());
			return serviceCaller.callService(ref.getServiceName(), params);
		}
	}

	public JSONObject defaultParametre(String refData, Class<? extends IParameters> clazz){
		// TODO Nesne sorgulama yazılacak
		return null;
	}
	
	public static Map<String, ReferenceData> getParams() {
		return params;
	}

	public static void setParams(Map<String, ReferenceData> params) {
		ReferenceDataService.params = params;
	}

}
