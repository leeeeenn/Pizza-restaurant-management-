/* leen ahmad 
 * 1212028
 * lab section 12 
 */

package application;
import java.util.*;
import java.util.Collections;
public class PizzaOrder implements Comparable<PizzaOrder>{
	/*
	 * creating private data fields
	 * 
	 */
private String customerName;
private Date dateOrdered;
final static int SMALL = 1, MEDIUM = 2, LARGE =3;
 int pizzaSize;
private int numberOfToppings;
private double toppingPrice;
/*
 * creating a default constructor
 */
public PizzaOrder() {
	
}
/*
 * creating a constructor with specified data fields
 */
public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice){
this.customerName = customerName;
this.pizzaSize= pizzaSize;
this.numberOfToppings = numberOfToppings;
this.toppingPrice = toppingPrice;
}
/*
 * appropriate setters and getters to reach the private attributes
 */
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public Date getDateOrdered() {
	Date dateOrdered = new Date();
	return dateOrdered;
}
public void setDateOrdered(Date dateOrdered) {
	this.dateOrdered = dateOrdered;
}
public int getNumberOfToppings() {
	return numberOfToppings;
}
public void setNumberOfToppings(int numberOfToppings) {
	this.numberOfToppings = numberOfToppings;
}
public double getToppingPrice() {
	return toppingPrice;
}
public void setToppingPrice(double toppingPrice) {
	this.toppingPrice = toppingPrice;
}
public double calculateOrderPrice() {
return ((numberOfToppings*toppingPrice)*pizzaSize);
}
@Override
public String toString() {
	return "PizzaOrder{" +
"\n the Customer Name is: " +customerName+
"\n the order date is: " + getDateOrdered() +
" \n the size of the pizza is: " +getPizzaSize()+
"\n the number of toppings is: " +numberOfToppings+
" \n the total price of toppings is: " +toppingPrice;
}
public void printInfo() {
	System.out.println(customerName+ ":" +calculateOrderPrice());
}

/**
 * a method implemented to sort the array list
 * since I used the collection.sort
 */
@Override
public int compareTo(PizzaOrder o) {
	if(calculateOrderPrice() > o.calculateOrderPrice()) 
		return 1;
	else if(calculateOrderPrice() < o.calculateOrderPrice())
		return -1;
	return 0;
}
/**
 * 
 * a method to convert the integer sizes to strings
 */
public String getPizzaSize() {
	if(pizzaSize == SMALL)
		return "SMALL";
	else if(pizzaSize == MEDIUM) 
return "MEDIUM";
	else
	return "LARGE";
	
}
}
