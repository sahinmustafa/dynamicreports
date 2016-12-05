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

import com.my.reports.utility.DataUtility;

/**
 * @author MustafaS.
 *
 */

public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent>{

	private static final Logger LOGGER = Logger.getLogger(ApplicationStartupListener.class);
	private static Map<String, String> serviceMap; 
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent params) {
		System.out.println("onApplicationEvent");
		createServiceMap();
	}
	
	private void createServiceMap(){
		serviceMap = new HashMap<String, String>();
		
		ClassPathScanningCandidateComponentProvider scanning = new ClassPathScanningCandidateComponentProvider(true);
		scanning.addIncludeFilter(new AnnotationTypeFilter(Service.class));
		Set<BeanDefinition> beans = scanning.findCandidateComponents(DefaultClassPath.SERVICE_PATH);
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
