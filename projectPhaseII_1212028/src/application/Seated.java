/*
* leen ahmad 
* 1212028
* lab section 12
*/
package application;
/*
* this class extends the PizzaOrder class
*/
public class Seated extends PizzaOrder {
	/*
	 * generating the private data fields
	 */
private double serviceCharge;
private int numberOfPeople;
/*
* creating default and non default constructors
*/
public Seated() {
	
}
/*
* using super res word to access the father class
*/
public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
super(customerName, pizzaSize, numberOfToppings, toppingPrice);
this.serviceCharge = serviceCharge;
this.numberOfPeople= numberOfPeople;
}
/*
* making both toString and the calculate method overridden to be accessed firstly for the subclass
*/
@Override
public String toString() {
	return "Seated [serviceCharge=" + serviceCharge + ", numberOfpeople=" + numberOfPeople + "]";
}
@Override
public double calculateOrderPrice() {
return(super.calculateOrderPrice() + (serviceCharge*numberOfPeople));	
}
}