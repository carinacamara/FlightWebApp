package ticket.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public User getUser(String username){
		return jdbcTemplate.query(User.IS_EXISTING_USER + "'"+ username + "'", new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					User aUser = new User();
					aUser.setIdUser(rs.getLong("idUser_role"));
					aUser.setUsername(rs.getString("username"));
					aUser.setRole(rs.getString("role"));
					
					
					return aUser;
				}
				
				return null;
			}
			
		});
	}
	
	public boolean userExists(String username){
		User aUser = getUser(username);
		
		if(aUser.equals(null)){
			return false;
		}
		return true;
	}

}
