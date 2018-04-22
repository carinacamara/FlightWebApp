package ticket.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	
	@Autowired
	private FlightDAO flDao;
	
	public List<Flight> getAllFlights(){
		return flDao.getAllFlights();
	}

	public void update(Flight flight){
		flDao.update(flight);
	}
	
	public void save(Flight flight){
		flDao.save(flight);
	}
	
	public void delete(Long idFlight){
		flDao.delete(idFlight);
	}
	
	public Flight getFlightById(Long idFlight){
		return flDao.getFlightById(idFlight);
	}
	
	
}
