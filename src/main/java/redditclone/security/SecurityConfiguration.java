package redditclone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}

	
	
    @Autowired
    public void configureAuthentication(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean()
            throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter
                .setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.headers().cacheControl().disable();
        httpSecurity.cors();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                
                .antMatchers(HttpMethod.GET, "/api/user/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/getAll/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/register/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/user/username/{username}/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/user/{username}/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/{id}/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/login/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/user/changePassword/{username}/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/oldPasswordVerification/{username}/").permitAll()
                
                .antMatchers(HttpMethod.GET, "/api/community/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/community/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/community/{name}/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/community/{name}/").permitAll()
                
                .antMatchers(HttpMethod.GET, "/api/post/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/post/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/post/{name}/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/post/{title}/").permitAll()
                
                .antMatchers(HttpMethod.GET, "/api/reaction/{post_id}/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reaction/voter/{voter_id}/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reaction/").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/reaction/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/reaction/").permitAll()
                
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
}