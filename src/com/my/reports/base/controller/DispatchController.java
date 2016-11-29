/**
 * 
 */
package com.my.reports.base.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MustafaS.
 *
 */
@Controller
public class DispatchController extends BaseController{
	
	private static final Logger LOGGER = Logger.getLogger(DispatchController.class);


	@RequestMapping(value="/dispatcher", method=RequestMethod.POST)
	public @ResponseBody String dispatch(@RequestBody String requestParams) throws Exception{
		LOGGER.info(requestParams);
		JSONObject request = new JSONObject(requestParams);
		JSONObject params = request.getJSONObject("params");
		String serviceName = request.getString("serviceName");
		
		JSONObject response = callService(serviceName, params);
		if(response == null)
			return null;
		response.put("success", true);
		return response.toString();
	}
		
}
