package school.repo;

import java.util.List;

import school.models.Subject;
import school.models.User;

public interface ISubjectRepository 
{
	List<Subject> getAll();
	Subject getById(Long id);
	void create(Subject subject);
	List<User> getAllUsersBySubject(Subject subject);

}
