import java.util.ArrayList;
 
public class Lockerblock
{
	private ArrayList<Locker> lockers;
	
	public Lockerblock(ArrayList<Locker> lockers)
	{
		this.lockers = lockers;
	}
	
	public ArrayList<Locker> getLockers()
	{
		return this.lockers;
	}
	
	public void addLocker(Locker locker)
	{
		lockers.add(locker);
	}
	
	public ArrayList<Locker> getAvailableLockers()
	{
		ArrayList<Locker> availableLockers = new ArrayList<Locker>();
		for(Locker locker : lockers)
		{
			if(locker.isAvailable() == true)
			{
				availableLockers.add(locker);
			}
		}
		return availableLockers;
	}
	
	public Locker getFirstAvailableLocker()
	{
		Locker firstAvailableLocker = null;
		for(Locker locker : lockers)
		{
			if(locker.isAvailable() == true)
			{
				return locker;
			}
		}
		if(firstAvailableLocker == null)
		{
			Locker lockerHighestPercentage = lockers.get(0);
			for(Locker locker : lockers)
			{
				if(locker.getLaptop().getBatteryPercentage() > lockerHighestPercentage.getLaptop().getBatteryPercentage())
				{
					lockerHighestPercentage = locker;
				}
				else if (locker.getLaptop().getBatteryPercentage() == lockerHighestPercentage.getLaptop().getBatteryPercentage())
				{
					if(locker.getLaptop().getCurrentMAH() > lockerHighestPercentage.getLaptop().getCurrentMAH())
					{
						lockerHighestPercentage = locker;
					}
				}
			}
			firstAvailableLocker = lockerHighestPercentage;
		}
		return firstAvailableLocker;
	}
	
	public void setLaptopInLocker(int lockerNumber, Laptop laptop)
	{
		for(Locker locker : lockers)
		{
			if(locker.getLockerNumber() == lockerNumber)
			{
				if(locker.isAvailable() == true)
				{
					locker.setLaptop(laptop);
				}
			}
		}
		
	}
	
	public double getRemainingChargeTime()
	{
		int totalCurrentMAH = 0;
		int totalMaxMAH = 0;
		for(Locker locker : lockers)
		{
			Laptop laptop = locker.getLaptop();
			if(laptop != null)
			{
				totalCurrentMAH += laptop.getCurrentMAH();
				totalMaxMAH += laptop.getMaxMAH();
			}
		}
		double totalRemainingMAH = totalMaxMAH - totalCurrentMAH;
		return totalRemainingMAH / 522;
	}
}