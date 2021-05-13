package br.camc.ProjetoFinalFull.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.camc.ProjetoFinalFull.enums.ERole;
import br.camc.ProjetoFinalFull.filters.JwtFilter;
import br.camc.ProjetoFinalFull.services.AppEncoder;
import br.camc.ProjetoFinalFull.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private AppEncoder encoder;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder);
		return provider;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.cors().and()			
			.authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers("/user/register").permitAll()
			.antMatchers("/user/authenticate").permitAll()			
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}
	
	
	
}
