package cg.jobapplication.jobapplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableAuthorizationServer

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	
	  private static final String RESOURCE_ID = "resource_id";

	    @Override
	    public void configure(ResourceServerSecurityConfigurer resources) {
	        resources.resourceId(RESOURCE_ID).stateless(false);
	    }

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.
	                anonymous().disable()
	                .requestMatchers().antMatchers("/register/**")
	    	        .and().authorizeRequests()
	    	        .antMatchers("/register/**").access("hasRole('ADMIN')")
	    	        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	    }
	   /* public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	        @Override
	        public void configure(HttpSecurity http) throws Exception {
	            http
	                    .authorizeRequests()
	                    .antMatchers("/").permitAll()
	                    .antMatchers("/api/v1/**").authenticated();
	        }*/
}
