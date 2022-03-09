package school.enums;

public enum Roles 
{
	STUDENT(1),
	PARENT(2),
	TEACHER(4),
	ADMINISTRATOR(8),
	HEADTEACHER(16);
	
	private int value;
	
	public int getValue()
	{
		return this.value;
	}
	
	Roles(int value)
	{
		this.value = value;
	}
	
	
}
