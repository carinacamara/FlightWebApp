package ticket.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	
	public static final String GET_BY_NAME = "Select * from City where name = ";
	
	@Id
	@Column
	private Long idCity;
	
	@Column
	private String name;
	
	@Column
	private Double latitude;
	
	@Column
	private Double longitude;
	
	

	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
	

}
