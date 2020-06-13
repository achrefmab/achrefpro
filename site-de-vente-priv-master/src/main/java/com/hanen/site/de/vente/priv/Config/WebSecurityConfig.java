package com.hanen.site.de.vente.priv.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hanen.site.de.vente.priv.repos.ClientRepos;
import com.hanen.site.de.vente.priv.services.MyUserDetailService;



@Configuration
//@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = ClientRepos.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailService userDetailsService;  
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
			
		
        http
            .authorizeRequests()
                .antMatchers("/","/resources/**", "/api/**","/login", "/client/add","/index").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.permitAll()
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/")
                .permitAll();
        
        http.csrf().disable();
    }


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(new PasswordEncoder() {

					@Override
					public String encode(CharSequence charseq) {
						
						return charseq.toString();
					}

					@Override
					public boolean matches(CharSequence arg0, String arg1) {
						
						return true;
					}
					
				});
		
	}
	
	
}