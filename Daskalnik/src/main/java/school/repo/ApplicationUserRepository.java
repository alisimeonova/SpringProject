package school.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.UserDetails;

@Repository
public class ApplicationUserRepository {
	@Autowired
	private JdbcTemplate connection;
	
	public void save(UserDetails user)
	{
		connection.update("INSERT INTO ApplicationUser "
				+ "(Username, Password, Enabled) VALUES (?,?,?)",
				user.getUsername(),
				user.getPassword(),
				user.isEnabled());
		
		connection.update("INSERT INTO Authorities "
				+ "(Username, Authority) VALUES (?,?)",
				user.getUsername(), "ROLE_USER");
	}
	
}
