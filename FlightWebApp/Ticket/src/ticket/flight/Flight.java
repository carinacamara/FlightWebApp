package ticket.flight;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Flight{
	
	public static final String GET_ALL_FLIGHTS = "Select * From Flight";
	public static final String FIND_FLIGHT_BY_ID = "Select * From Flight Where idFlight = ";
	public static final String DELETE_FLIGHT = "Delete From Flight Where idFlight = ";
	public static final String INSERT_FLIGHT = "INSERT INTO Flight (airplaneType, departureCity, arrivalCity, departureDate, arrivalDate, departureHour, arrivalHour)  VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_FLIGHT = "UPDATE Flight SET  airplaneType=?, departureCity=?, arrivalCity=?, departureDate=?, arrivalDate=?, departureHour=?, arrivalHour=? WHERE idFlight=?";
	
	@Id
	@Column
	private Long idFlight;
	
	@Column
	private String airplaneType;
	
	@Column
	private String departureCity;
	
	@Column
	private String arrivalCity;
	
	@Column
	private Date departureDate;
	
	@Column
	private Date arrivalDate;
	
	@Column
	private String departureHour;
	
	@Column
	private String arrivalHour;
	
	
	
	
	public Flight() {}

	public Flight(String airplaneType, String departureCity, String arrivalCity, Date departureDate, Date arrivalDate,
			String departureHour, String arrivalHour) {
		this.airplaneType = airplaneType;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureHour = departureHour;
		this.arrivalHour = arrivalHour;
	}

	public Long getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Long idFlight) {
		this.idFlight = idFlight;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(String departureHour) {
		this.departureHour = departureHour;
	}

	public String getArrivalHour() {
		return arrivalHour;
	}

	public void setArrivalHour(String arrivalHour) {
		this.arrivalHour = arrivalHour;
	}
	
	
	
}
