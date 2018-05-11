import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class Order {
   public String OrderId;
   public ArrayList<Pizza> pizza;
   public String CustomerName;
   public OrderType type;
   public double price;
   
   Order(ArrayList<Pizza> p , String name , OrderType t )
   {
	   this.pizza = p;
	   this.CustomerName = name;
	   this.type = t;
	   this.OrderId = RandomString();
	   
   }
   
   public String RandomString() {
	    byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	 
	    return generatedString;
	}
   
   public String generateBill()
   {
	   String bill = "";
	   bill = "Dear "+ CustomerName+ ",\n"+"Your Order No : " + OrderId +" is placed\n"+"Price(INR) : "+ price+"\nPayment Type : "+ type.toString();
	   return bill;
   }
}
