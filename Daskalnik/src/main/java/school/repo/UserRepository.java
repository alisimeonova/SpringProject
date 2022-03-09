package school.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import school.models.Subject;
import school.models.User;

@Repository("userRepository")
public class UserRepository implements IUserRepository
{
	private Map<Long, User> users = new HashMap<>();
	private Long id = 0L;

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(users.values());
	}

	@Override
	public User getById(Long id) {
		return users.get(id);
	}

	@Override
	public void create(User user) {
		user.setId(++id);
		users.put(id, user);
	}

	@Override
	public List<Subject> getAllSubjectsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
