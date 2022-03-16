package school.init;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import school.models.Subject;

@Component
public class DatabaseInit implements CommandLineRunner{

	private JdbcTemplate jdbc;
	
	@Override
	public void run(String... args) throws Exception 
	{
		jdbc.update("CREATE TABLE Subjects(ID AUTOINCREMENT NOT NULL,"
				+ "Name Text NOT NULL,"
				+ "PRIMARY KEY(ID))");
		jdbc.update("CREATE TABLE Users(ID AUTOINCREMENT NOT NULL,"
				+ "FirstName Text NOT NULL,"
				+ "LastName Text NOT NULL,"
				+ "Email Text NOT NULL,"
				+ "Address Text NOT NULL,"
				+ "Role Number NOT NULL,"
				+ "PRIMARY KEY(ID))");
		jdbc.update("CREATE TABLE Relationship WHERE Subjects.ID = Users.ID");
	}

}
