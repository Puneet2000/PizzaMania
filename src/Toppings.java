
public enum Toppings {
	ONION(50),
	ONION_AND_PANEER(80),
	PEPPY_PANEER(80),
	MARGHERITA(80),
	VEG_LOADED(90),
	PANEER_MAKHANI(100),
	CHICKEN_TIKKA(100),
	NON_VEG_SPECIAL(120),
	CHICKEN_SAUSAGE(110),
	PIZZA_MANIA_SPECIAL(150);
	
	private int price;
	Toppings(int price)
	{
		this.price = price;
	}
	public int getPrice()
	{
		return price;
	}

}
