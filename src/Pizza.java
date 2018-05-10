
public class Pizza {
	public Breads bread;
	public Sizes size;
	public Toppings topping;
	public Cheese cheese;
	public int quantity;

	
	Pizza(Breads b , Sizes s , Toppings t , Cheese c , int q)
	{
		this.bread =b;
		this.size =s;
		this.topping = t;
		this.cheese =c;
		this.quantity =q;
	}
	
	public double getPrice()
	{
		double price=0;
		price = (bread.getPrice() + topping.getPrice() + cheese.getPrice())*(size.getFactor())*(quantity);
		return price;
		
	}
	
	

}
