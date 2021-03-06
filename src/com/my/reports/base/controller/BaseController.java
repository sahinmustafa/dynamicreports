/**
 * 
 */
package com.my.reports.base.controller;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import com.my.reports.base.entity.BaseEntity;
import com.my.reports.base.entity.ServiceResult;
import com.my.reports.base.service.BaseService;
import com.my.reports.base.spring.ApplicationStartupListener;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */
@Component
public class BaseController {

	private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	@Autowired private AutowireCapableBeanFactory beanFactory;

	public JSONObject callService(String serviceName, JSONObject params) {
		LOGGER.info(serviceName + " isimli servis çağrıldı.");

		try {
			if (DataUtility.isNullOrEmpty(serviceName) || !serviceName.contains("_")) {
				LOGGER.error("Geçersiz servis adı");
				return null;
			}

			BaseService baseService = getServiceClass(serviceName);
			Method serviceMethod = getServiceMethod(baseService.getClass(), serviceName);
			Object[] methodParams = getMethodParams(serviceMethod, params);
			ServiceResult serviceResult = (ServiceResult) serviceMethod.invoke(baseService, methodParams);
			return formattedReturnValue(serviceResult);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.error(ex.getCause());
			
			JSONObject result = new JSONObject();
			result.put("msg", new String[]{ex.getCause().getMessage()});
			result.put("error", false);
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	private BaseService getServiceClass(String serviceName) throws Exception {
		String simpleName = DataUtility.upperCaseFirstChar(serviceName.substring(0, serviceName.indexOf("_")));
		String fullName = ApplicationStartupListener.getServiceNameFromSimpleName(simpleName);

		Class<? extends BaseService> clazz = null;
		try {
			clazz = (Class<? extends BaseService>) Class.forName(fullName);
			BaseService baseService = clazz.newInstance();
			beanFactory.autowireBean(baseService);
			return baseService;
		} catch (ClassNotFoundException e) {
			LOGGER.error(simpleName + " isimli servis bulunamadı.");
			throw new Exception(e);
		} catch (InstantiationException e) {
			LOGGER.error(simpleName + " isimli servisten yeni bir instance üretilmedi.");
			throw new Exception(e);
		} catch (IllegalAccessException e) {
			LOGGER.error(simpleName + " isimli servise illegal olarak erişmeye çalışılıyor.");
			throw new Exception(e);
		}
	}

	private Method getServiceMethod(Class<? extends BaseService> clazz, String serviceName) throws Exception {
		String methodName = serviceName.substring(serviceName.indexOf("_") + 1);

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods)
			if (method.getName().equals(methodName))
				return method;

		LOGGER.error(clazz.getSimpleName() + " servis sınıfı içerisinde " + methodName + " isimli metod bulunamadı.");
		throw new Exception();
	}
 
	private Object[] getMethodParams(Method method, JSONObject params) throws Exception {
		Parameter[] methodParameters = method.getParameters();
		Object[] methodParam = new Object[methodParameters.length];

		for (int i = 0; i < methodParameters.length; i++) {
			Parameter param = methodParameters[i];
			String paramName = param.getName();
			Class<?> paramType = param.getType();

			methodParam[i] = getParamsValue(paramName, paramType, params);
		}
		return methodParam;
	}

	@SuppressWarnings("unchecked")
	private Object getParamsValue(String paramName, Class<?> paramType, JSONObject params) throws Exception {
		if (!params.has(paramName))
			return null;

		if (paramType.equals(String.class))
			return params.getString(paramName);
		else if (paramType.equals(int.class) || paramType.equals(Integer.class))
			return params.getInt(paramName);
		else if (paramType.equals(double.class) || paramType.equals(Double.class))
			return params.getDouble(paramName);
		else if (paramType.equals(float.class) || paramType.equals(Float.class))
			return params.getDouble(paramName);
		else if (paramType.equals(long.class) || paramType.equals(Long.class))
			return params.getLong(paramName);
		else if (paramType.equals(boolean.class) || paramType.equals(Boolean.class))
			return params.getBoolean(paramName);
		else if (paramType.equals(Class.class))
			return (Class<?>) params.get(paramName);
		else if (paramType.getSuperclass().equals(BaseEntity.class)) {
			BaseEntity entity = (BaseEntity) paramType.newInstance();
			return entity.fromJSON((Class<? extends BaseEntity>) paramType, params.getJSONObject(paramName));
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private JSONObject formattedReturnValue(ServiceResult serviceResult) throws JSONException, Exception {
		JSONObject returnValue = new JSONObject();

		if (DataUtility.isNull(serviceResult)) {
			returnValue.put("data", serviceResult);
			return returnValue;
		}
		Object o = serviceResult.getData();

		if (DataUtility.isNull(o))
			returnValue.put("data", o);
		else if (o instanceof BaseEntity) {
			BaseEntity newO = (BaseEntity) o;
			returnValue.put("data", newO.toJSON());
		} else if (o instanceof List) {
			List<Object> list = (List<Object>) o;
			JSONArray arr = new JSONArray();
			if (list.size() > 0) {
				if (list.get(0) instanceof BaseEntity) {
					for (int i = 0; i < list.size(); i++)
						arr.put(((BaseEntity) list.get(i)).toJSON());
				} else
					arr = new JSONArray(list);
			}
			returnValue.put("data", arr);
		} else {
			returnValue.put("data", o);
		}
		JSONArray messages = new JSONArray();
		if (!DataUtility.isNull(serviceResult.getMessages())) {
			for (String message : serviceResult.getMessages())
				messages.put(message);
			
		}
		returnValue.put("msg", messages);

		return returnValue;
	}
}
