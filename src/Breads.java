
public enum Breads {
	REGULAR_BASE(20),
	FRESH_BASE(30);
	 
	private int price;
	Breads(int price)
	{
		this.price = price;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	

}
