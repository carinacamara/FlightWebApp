package ticket.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ticket.city.CityDAO;
import ticket.flight.FlightDAO;
import ticket.user.UserDAO;

@Configuration
@ComponentScan("ticket/")
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Airport");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
}
	@Bean
	public FlightDAO getFlightDao() {
		return new FlightDAO(getDataSource());
}
	@Bean
	public UserDAO getUserDao(){
		return new UserDAO(getDataSource());
	}
	
	@Bean
	public CityDAO getCityDao(){
		return new CityDAO(getDataSource());
	}

}