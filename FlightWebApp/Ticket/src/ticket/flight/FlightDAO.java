package ticket.flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class FlightDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public FlightDAO(DataSource dataSource){
		 jdbcTemplate = new JdbcTemplate(dataSource);
}
	

	
	public List<Flight> getAllFlights(){
		
		List<Flight> flights = jdbcTemplate.query(Flight.GET_ALL_FLIGHTS, new RowMapper<Flight>() {
			@Override
			public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
				Flight aFlight= new Flight();
	
				aFlight.setIdFlight(rs.getLong("idFlight"));
				aFlight.setAirplaneType(rs.getString("airplaneType"));
				aFlight.setDepartureCity(rs.getString("departureCity"));
				aFlight.setArrivalCity(rs.getString("arrivalCity"));
				aFlight.setDepartureDate(rs.getDate("departureDate"));
				aFlight.setArrivalDate(rs.getDate("arrivalDate"));
				aFlight.setArrivalHour(rs.getString("arrivalHour"));
				aFlight.setDepartureHour(rs.getString("departureHour"));
			
				
				
				return aFlight;
			}
			
		});
		
		return flights;
	}


	public void update(Flight flight) {
			
			jdbcTemplate.update(Flight.UPDATE_FLIGHT,  flight.getAirplaneType(), flight.getDepartureCity(),
					flight.getArrivalCity(), flight.getDepartureDate(), flight.getArrivalDate(), flight.getDepartureHour(), flight.getArrivalHour(), flight.getIdFlight());
		} 
	
	public void save(Flight flight){
	
			jdbcTemplate.update(Flight.INSERT_FLIGHT, flight.getAirplaneType(), flight.getDepartureCity(),
					flight.getArrivalCity(), flight.getDepartureDate(), flight.getArrivalDate(),flight.getDepartureHour(), flight.getArrivalHour());
	
		
		
	}
	
	public Flight getFlightById(Long idFlight) {
		
		return jdbcTemplate.query(Flight.FIND_FLIGHT_BY_ID + idFlight, new ResultSetExtractor<Flight>() {

			@Override
			public Flight extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Flight aFlight = new Flight();
					aFlight.setIdFlight(rs.getLong("idFlight"));
					aFlight.setAirplaneType(rs.getString("airplaneType"));
					aFlight.setDepartureCity(rs.getString("departureCity"));
					aFlight.setArrivalCity(rs.getString("arrivalCity"));
					aFlight.setDepartureDate(rs.getDate("departureDate"));
					aFlight.setArrivalDate(rs.getDate("arrivalDate"));
					aFlight.setArrivalHour(rs.getString("arrivalHour"));
					aFlight.setDepartureHour(rs.getString("departureHour"));
					
					return aFlight;
				}
				
				return null;
			}
			
		});
	}

	public void delete(Long idFlight){
		 
		jdbcTemplate.execute(Flight.DELETE_FLIGHT + idFlight);

	}
	

}
