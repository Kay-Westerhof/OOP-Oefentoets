import java.util.Arrays;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) 
	{
		Laptop laptop1 = new Laptop ("123", 50.0, 100.0);
		Laptop laptop2 = new Laptop ("234", 30, 100);
		System.out.println(laptop1.getBatteryPercentage());
		Locker locker1 = new Locker(1, laptop1);
		Locker locker2 = new Locker(2);
		System.out.println(locker1.isAvailable());
		System.out.println(locker2.isAvailable());
		Lockerblock lockerblock1 = new Lockerblock(new ArrayList<Locker>(Arrays.asList(locker1, locker2)));
		System.out.println("Available lockers: " + lockerblock1.getAvailableLockers());
		System.out.println("First available: " + lockerblock1.getFirstAvailableLocker());
		System.out.println("Remaining chargetime: " + lockerblock1.getRemainingChargeTime());
		System.out.println("Laptop locker2: " + locker2.getLaptop());
		lockerblock1.setLaptopInLocker(2, laptop2);
		System.out.println("Laptop locker2: " + locker2.getLaptop());
	}
}