package com.my.reports.base.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.my.reports.base.spring.utils.ApplicationStartupListener;

/**
 * @author MustafaS.
 *
 */

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext container) { 
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebConfig.class);
        dispatcherServlet.addApplicationListener(new ApplicationStartupListener());
        System.out.println("onStartup");
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
    }

}
