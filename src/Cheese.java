
public enum Cheese {
	NORMAL(30),
	EXTRA(50),
	LOADED(80);
	
	private int price;
	Cheese(int price)
	{
		this.price = price;
		
	}
	public int getPrice()
	{
		return price;
	}

}
