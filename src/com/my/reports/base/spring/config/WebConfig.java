package com.my.reports.base.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.my.reports.base.spring.utils.DatabaseConfig;

/**
 * @author MustafaS.
 *
 */

@Configuration
@EnableWebMvc
@Import({ DatabaseConfig.class })
@ComponentScan({ DefaultClassPath.BASE_PATH, 
				 DefaultClassPath.CONTROLLER_PATH,
				 DefaultClassPath.SERVICE_PATH,
				 DefaultClassPath.ENTITY_PATH})
public class WebConfig extends WebMvcConfigurerAdapter {

	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
	
	@Bean
    public InternalResourceViewResolver configureInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".js"); 
        return resolver;
    }
}
