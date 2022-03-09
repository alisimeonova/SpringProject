package school.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import school.models.Subject;
import school.models.User;

@Repository("subjectRepository")
public class SubjectRepository implements ISubjectRepository
{
	private Map<Long, Subject> subjects = new HashMap<>();
	private Long id = 0L;

	@Override
	public List<Subject> getAll() {
		return new ArrayList<Subject>(subjects.values());
	}

	@Override
	public Subject getById(Long id) {
		return subjects.get(id);
	}

	@Override
	public void create(Subject subject) {
		subject.setId(++id);
		subjects.put(id, subject);
	}

	@Override
	public List<User> getAllUsersBySubject(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
