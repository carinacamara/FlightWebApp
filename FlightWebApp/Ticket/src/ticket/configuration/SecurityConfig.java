package ticket.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       
		DriverManagerDataSource DataSource = new DriverManagerDataSource();
		DataSource.setDriverClassName("com.mysql.jdbc.Driver");
		DataSource.setUrl("jdbc:mysql://localhost:3306/Airport");
		DataSource.setUsername("root");
		DataSource.setPassword("root");
		
		auth.jdbcAuthentication().dataSource(DataSource)
		.usersByUsernameQuery(
			"select username, password, enable from User where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from User_role where username=?");
}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/user/**").access("hasRole('ROLE_USER')")
		        .antMatchers("/").permitAll()
		        .and().formLogin()
				.and().exceptionHandling().accessDeniedPage("/403")
				.and().csrf();
		
	}


}
