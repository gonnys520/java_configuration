package org.gonnys.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages= {"org.gonnys.controller"})
public class ServletConfig implements WebMvcConfigurer {
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1024*1024*10);
		resolver.setUploadTempDir(new FileSystemResource("C:\\upload\\temp"));
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver =
				new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		
		//jstl 쓰고 싶다면 추가
		resolver.setViewClass(JstlView.class);
		
		registry.viewResolver(resolver);
	}

	
	
}
