/*
 * leen ahmad
 * 1212028
 * lab section 12
 */
package application;
 /*
  * this class extends the PizzaOrder class
  */
public class ToGo extends PizzaOrder {
	/*
	 * appropriate constructor with super keyword for accessing the father class
	 */
public ToGo (String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
	super(customerName, pizzaSize, numberOfToppings, toppingPrice);
}
}
