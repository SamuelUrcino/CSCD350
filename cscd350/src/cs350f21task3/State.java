package cs350f21task3;
//ignore toString()
public class State {

	private double x,y,z,heading,speedHorizontal,speedVertical,accelerationHorizontal,turnRate;
	
	public State(double x, double y, double z, double heading, double speedHorizontal, 
			     double speedVertical, double accelerationHorizontal, double turnRate)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.heading = heading;
		this.speedHorizontal = speedHorizontal;
		this.speedVertical = speedVertical;
		this.accelerationHorizontal = accelerationHorizontal;
		this.turnRate = turnRate;
	}
	
	public double getAcceleration()
	{
		return this.accelerationHorizontal;
	}
	
	public double getHeading()
	{
		return 0;
	}
	
	public double getHeadingTarget()
	{
		return 0;
	}
	
	public double getHeadingTargetDirection()
	{
		return 0;
	}
	
	public double getSpeedHorizontal()
	{
		return 0;
	}
	
	public double getSpeedHorizontalTarget()
	{
		return 0;
	}
	
	public void setSpeedHorizontalTarget(double speed)
	{
	}
	
	public double getSpeedVertical()
	{
		return 0;
	}
	
	public void setSpeedVertical(double speed)
	{
		
	}
	
	public String getStateCSV()
	{
		return "";
	}
	
	public double getTurnRate()
	{
		return 0;
	}
	
	public double getX()
	{
		return 0;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public double getZ()
	{
		return 0;
	}
	
	public void setHeadingTarget(double heading, boolean direction)
	{
		
	}
	
	public void update()
	{
		
	}
}