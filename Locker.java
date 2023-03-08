public class Locker
{
	private int lockerNumber;
	private Laptop laptop;
	
	public Locker(int lockerNumber, Laptop laptop)
	{
		this.lockerNumber = lockerNumber;
		this.laptop = laptop;
	}
	
	public Locker(int lockerNumber)
	{
		this.lockerNumber = lockerNumber;
		this.laptop = null;
	}
	
	public boolean isAvailable()
	{
		if(laptop == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setLaptop(Laptop laptop)
	{
		this.laptop = laptop;
	}
	
	public Laptop getLaptop()
	{
		return this.laptop;
	}
	
	public int getLockerNumber()
	{
		return this.lockerNumber;
	}
	
}