/*
 * leen ahmad
 * 1212028
 * lab section 12
 */
package application;
import java.util.*;
/*
 * this class is an extension of PizzaOrder clas
 */
public class Delivery extends PizzaOrder {
	/*
	 * creating private data fields
	 */
private double tripRate;
private int zone;
public Delivery() {
	
}
/*
 * creating constructor with arguments using super reserved word to access the consturctor in the father class
 */
public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
	super(customerName, pizzaSize, numberOfToppings, toppingPrice);
	this.tripRate = tripRate;
	this.zone = zone;
}
/*
 * generating the setters and getters to reach the data fields
 */
public double getTripRate() {
	return tripRate;
}
public void setTripRate(double tripRate) {
	this.tripRate = tripRate;
}
public int getZone() {
	return zone;
}
public void setZone(int zone) {
	this.zone = zone;
}
@Override 
public String toString() {
return super.toString() + "\n for Delivery: " +
		"\n the trip rate is" +tripRate+
		" \n the zone is " +zone+
		"}";

}
/*
 * making the method overridden to access it from the subclass 
 */
@Override
public double calculateOrderPrice() {
return (super.calculateOrderPrice() + (tripRate/100* super.calculateOrderPrice()*zone));
}
}


