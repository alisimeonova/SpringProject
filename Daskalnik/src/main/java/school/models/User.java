package school.models;

import school.enums.Roles;

public class User 
{
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String password;
	private Roles role;

	public User(String firstName, String lastName, String email,
			String address, String password)
	{
		id = 0L;
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setAddress(address);
		setPassword(password);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.isEmpty())
			this.firstName = firstName;
		throw new IllegalArgumentException("Invalid first name");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.isEmpty())
			this.lastName = lastName;
		throw new IllegalArgumentException("Invalid last name");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	public String toString()
	{
		String result = String.format("%s %s email: %s address: %s", getFirstName(),
				getLastName(), getEmail(), getAddress());
		return result;   
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		if(!(o instanceof User))
			return false;
		
		User toCompare = (User)o;
		return toCompare.getId() == getId();
	}
	
	@Override 
	public int hashCode()
	{
		return getId().hashCode();
	}
	
	

}
