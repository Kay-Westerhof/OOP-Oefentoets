public class Laptop
{
	private String serialNumber;
	private double currentMAH;
	private double maxMAH;
	
	public Laptop(String serialNumber, double currentMAH, double maxMAH)
	{
		this.serialNumber = serialNumber;
		this.currentMAH = currentMAH;
		this.maxMAH = maxMAH;
	}
	
	public double getBatteryPercentage()
	{
		return this.currentMAH / this.maxMAH * 100;
	}
	
	public String getSerialNumber()
	{
		return this.serialNumber;
	}
	
	public double getCurrentMAH()
	{
		return this.currentMAH;
	}
	
	public double getMaxMAH()
	{
		return this.maxMAH;
	}
}