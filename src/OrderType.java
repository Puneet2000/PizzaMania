
public enum OrderType {
    CASH_ON_DELIVERY(1),
    ONLINE(0.9);
	
	private double factor;
	OrderType(double factor)
	{
		this.factor = factor;
	}
	public double getFactor()
	{
		return factor;
	}
    
}
