package org.db.sb.svc.usr.config;

import org.db.sb.svc.usr.ws.filter.JwtFilter;
import org.db.sb.svc.ws.AbstractServiceController;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WsConfiguration {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/" + AbstractServiceController.BASE_API_PATH + "*");
		return registrationBean;
	}

}
