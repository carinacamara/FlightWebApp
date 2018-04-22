package ticket.city;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ticket.user.User;

public class CityDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public CityDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public City getByName(String name){
		return jdbcTemplate.query(City.GET_BY_NAME + "'"+ name + "'", new ResultSetExtractor<City>() {

			@Override
			public City extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					City aCity = new City();
					aCity.setIdCity(rs.getLong("idCity"));
					aCity.setName(rs.getString("name"));
					aCity.setLatitude(rs.getDouble("latitude"));
					aCity.setLongitude(rs.getDouble("longitude"));
					
					return aCity;
				}
				
				return null;
			}
			
		});
		
	}
}
