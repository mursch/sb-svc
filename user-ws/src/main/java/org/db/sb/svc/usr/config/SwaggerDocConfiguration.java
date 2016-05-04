package org.db.sb.svc.usr.config;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfiguration {

	@Bean
	public Docket petApi() {
		Properties properties = loadSwaggerProperties();
		if (properties == null) {
			return null;
		}
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage(properties.getProperty("base.package")))
					.paths(PathSelectors.any())
					.build()
				.pathMapping(properties.getProperty("base.path"))
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				;
	}

	private Properties loadSwaggerProperties() {
		Properties properties = new Properties();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream is = cl.getResourceAsStream("swagger.properties");
		try {
			properties.load(is);
		} catch (Exception e) {
			return null;
		}
		return properties;
	}
}
