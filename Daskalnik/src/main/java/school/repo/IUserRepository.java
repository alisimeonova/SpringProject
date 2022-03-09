package school.repo;

import java.util.List;

import school.models.Subject;
import school.models.User;

public interface IUserRepository 
{
	List<User> getAll();
	User getById(Long id);
	void create(User user);
	List<Subject> getAllSubjectsByUser(User user);

}
