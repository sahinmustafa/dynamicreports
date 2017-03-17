/**
 * 
 */
package com.my.reports.base.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;

import com.my.reports.base.enums.ReferenceData;
import com.my.reports.base.enums.definitions.IReferenceData;
import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */

public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent>{

	private static final Logger LOGGER = Logger.getLogger(ApplicationStartupListener.class);
	private static Map<String, String> serviceMap; 
	private static Map<String, IReferenceData> refDataMap;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent params) {
		System.out.println("onApplicationEvent");
		
		createServiceMap(DefaultClassPath.SERVICE_PATH);
		createServiceMap(DefaultClassPath.BASE_PATH + ".service");
		
		createRefDataMap(ReferenceData.class);
	}
	
	private void createRefDataMap(Class<? extends IReferenceData> refDataClass){
		
		if(DataUtility.isNull(refDataMap))
			refDataMap = new HashMap<String, IReferenceData>();
		
		for(IReferenceData refData : refDataClass.getEnumConstants()){
			refDataMap.put(refData.getRefData(), refData);
		}
	}
	
	public static IReferenceData getReferenceDataFromRefData(String refData) throws Exception {
		IReferenceData referenceData = refDataMap.get(refData);
		DataUtility.isNull(referenceData, true, "Geçersiz referans adı");
		return referenceData;
	}
	
	private void createServiceMap(String path){
		
		if(serviceMap == null)
			serviceMap = new HashMap<String, String>();
		
		ClassPathScanningCandidateComponentProvider scanning = new ClassPathScanningCandidateComponentProvider(true);
		scanning.addIncludeFilter(new AnnotationTypeFilter(Service.class));
		Set<BeanDefinition> beans = scanning.findCandidateComponents(path);
		for(BeanDefinition bean : beans ){
			String className = bean.getBeanClassName();
			String simpleName = DefaultClassPath.getSimpleClassName(className);
			serviceMap.put(simpleName, className);
		}
	}

	public static String getServiceNameFromSimpleName(String simpleName) {
		String serviceName = serviceMap.get(simpleName);
		if(DataUtility.isNullOrEmpty(serviceName))
			LOGGER.error(simpleName + " isimli servis sınıfı bulunamadı.");
		
		return serviceName;
	}

}
