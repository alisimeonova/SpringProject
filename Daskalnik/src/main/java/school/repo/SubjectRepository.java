package school.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import school.models.Subject;
import school.models.User;

@Repository("subjectRepository")
public class SubjectRepository implements ISubjectRepository
{
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Subject> getAll() {
		List<Subject> result = jdbc.query("SELECT * FROM Subjects", 
				new RowMapper<Subject>() {

					@Override
					public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
						Subject subject = new Subject(
								rs.getString("Name"));
						subject.setId(rs.getLong("ID"));
						return subject;
					}
			
		});
		return result;
	}

	@Override
	public Subject getById(Long id) {
		Subject subject = jdbc.queryForObject("SELECT * FROM Subjects WHERE ID = ?", 
				new RowMapper<Subject>() {

					@Override
					public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
						Subject subject = new Subject(
								rs.getString("Name"));
						subject.setId(rs.getLong("ID"));
						return subject;
					}
			
		}, id);
		return subject;
	}

	@Override
	public void create(Subject subject) {
		jdbc.query("INSERT INTO Subjects", new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				subject.setName(rs.getString("Name"));
				subject.setId(rs.getLong("ID"));
				return subject;
			}
		
		}, subject);    
	}

	@Override
	public List<User> getAllUsersBySubject(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
