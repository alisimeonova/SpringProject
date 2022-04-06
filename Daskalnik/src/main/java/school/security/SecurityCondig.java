package school.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class SecurityCondig extends WebMvcConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpEntity http) throws Exception {
		http.
			authorizeRequests().
			antMatchers("/register/user", 
					"/articles/home", 
					"/articles/article/*", 
					"/style.css", 
					"/h2/**",
					"/articles/add").
			
			permitAll().
			and().
			authorizeRequests().
			antMatchers(HttpMethod.POST, "/register/user", "/articles/add").
			permitAll().
			anyRequest().
			authenticated().
			and().
			formLogin().
			loginPage("/login").
			permitAll();

		
		//http.csrf().disable();
		http.csrf()
        .ignoringAntMatchers("/h2/**","/register/user", "/articles/add");
		http.headers()
        .frameOptions()
        .sameOrigin();
        
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			/*.withDefaultSchema()*/
			/*.withUser(User.withUsername("svetlio")
					.roles("USER")
					.password(getPasswordEncoder().encode("jaja")))*/
			.dataSource(dataSource);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
}
