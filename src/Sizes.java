
public enum Sizes {
	REGULAR(1),
	MEDIUM(1.5),
	LARGE(2);
	
	private double factor;
	Sizes(double factor)
	{
		this.factor = factor;
	}
	public double getFactor()
	{
		return factor;
	}
	

}
