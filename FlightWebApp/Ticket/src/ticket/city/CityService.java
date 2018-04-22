package ticket.city;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	private CityDAO cityDao;
	
	
	public String getTime(String name) throws IOException{
		
		City city = cityDao.getByName(name);
		
		String URL = "http://www.earthtools.org/timezone/" + city.getLatitude() + "/" + city.getLongitude(); 
		String charset = "UTF-8";
		String localDate = "value1";
		
		String query = String.format("localDate=%s", 
		     URLEncoder.encode(localDate, charset));
				
		
		HttpURLConnection httpConnection = (HttpURLConnection) new URL(URL).openConnection();
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Accept-Charset", charset);
		httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

		try (OutputStream output = httpConnection.getOutputStream()) {
		    output.write(query.getBytes(charset));
		
		}

	
		
		return localDate;
		
	}
	
	 
	
}
