package school.models;

public class Subject 
{
	private Long id;
	private String name;
	
	public Subject(String name)
	{
		id = 0L;
		setName(name);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null && !name.isEmpty())
			this.name = name;
		throw new IllegalArgumentException("Invalid name for subject");
	}
	
	public String toString()
	{
		String result = String.format("Subject: %s", getName());
		return result;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		if(!(o instanceof Subject))
			return false;
		
		Subject toCompare = (Subject)o;
		return toCompare.getId() == getId();
	}
	
	@Override
	public int hashCode()
	{
		return getId().hashCode();
	}
	

}
