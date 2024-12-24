
/*leen ahmad 
 * 1212028
 * section 12 
 */
package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import application.PizzaOrder;
import application.Seated;
import application.Delivery;
import application.ToGo;

public class Main extends Application {
	@Override
	//creating my java fx interface using grid panes and border panes to design it
	public void start(Stage primaryStage) {
		try { 
			ArrayList <PizzaOrder> orders = new ArrayList();
			BorderPane root = new BorderPane();
			root.setPadding(new Insets (20));
			GridPane gp = new GridPane();
			Label customername = new Label(" customer name");
			Label toppingPrice = new Label("topping price ");
			Label orderPrice = new Label("order price");
			gp.add(customername, 0, 0);
			gp.add(toppingPrice, 0, 4);
			gp.add(orderPrice, 0, 5);
			
			root.setTop(gp); 
			//creation of comvbobox for the the toppings
				ComboBox<String> orderType = new ComboBox();
				orderType.getItems().addAll("TO GO"," DELIVERY", "SEATED");
				orderType.setValue("TO GO");
				// creation of toppings
				CheckBox top1 = new CheckBox("olives");
				CheckBox top2 = new CheckBox("green pepper");
				CheckBox top3 = new CheckBox("salami");
				CheckBox top4 = new CheckBox("onions");
				CheckBox top5 = new CheckBox("pinapple");
				//made an arraylist to add the toppings then setting them on the menu
				ArrayList<CheckBox> toptype = new ArrayList<> ();
				toptype.add(top1);
				toptype.add(top2);
				toptype.add(top3);
				toptype.add(top4);
				toptype.add(top5);
			GridPane topGd = new GridPane();
			topGd.add(top1, 0, 0);
			topGd.add(top2, 0, 1);
			topGd.add(top3, 0, 2);
			topGd.add(top4, 0, 3);
			topGd.add(top5, 0, 4);
			TextField customernm = new TextField("");
			TextField topPrice = new TextField("10");
			TextField ordPrice = new TextField("0.0");
			gp.add(customernm, 1, 0);
			gp.add(orderType, 1, 2);
			gp.add(topGd, 1, 3);
			gp.add(topPrice, 1, 4);
			gp.add(ordPrice, 1, 5);
			GridPane del = new GridPane();
				Label tripRt = new Label("trip rate");
				Label zone = new Label("trip rate");
				TextField trip = new TextField("0");
				TextField tzone= new TextField("0");
				del.add(tripRt, 0, 0);
				del.add(trip, 1,0);
				del.add(zone, 0, 1);
				del.add(tzone, 1, 1);
				GridPane seat = new GridPane();
				
				Label sevicechar = new Label("service charge");
				Label numofppl = new Label("number of people ");
				TextField sevice = new TextField();
				TextField num = new TextField();
				seat.add(sevicechar, 0, 0);
				seat.add(sevice, 1, 0);
				seat.add(numofppl, 0, 1);
				seat.add(num, 1, 1);
				seat.setVisible(false);
				del.setVisible(false);
				
					VBox setting = new VBox();
					setting.getChildren().addAll(gp ,del, seat);
					root.setCenter(setting);
					setting.setAlignment(Pos.CENTER);
					orderType.setOnAction(e ->{
						if(Objects.equals(orderType.getValue(), "TO GO")) {
							del.setVisible(false);
						seat.setVisible(false);
					}
						else if(Objects.equals(orderType.getValue(), "SEATED")) {
							del.setVisible(false);
							seat.setVisible(true);	
						}
						else {
							del.setVisible(true);
						seat.setVisible(false);
							
						}});	
				
				ComboBox <String> pzSize = new ComboBox();
				pzSize.getItems().addAll("Small", "Medium", "Large");
				pzSize.getSelectionModel().select(0);
				VBox coll = new VBox();
				coll.getChildren().addAll(pzSize, setting);
			root.setCenter(coll);
				
				//creation of the three bottom buttons
			
			
			Button ProcessOrder = new Button ("process order ");
			Button PrintOrders = new Button ("print orders");
			Button Reset  = new Button ("reset");
			HBox buttons = new HBox();
			buttons.getChildren().addAll(ProcessOrder, PrintOrders, Reset);
			buttons.setAlignment(Pos.CENTER);
			root.setBottom(buttons);
		    PrintOrders.setOnAction(e->{
	            Stage secStage = new Stage();
	            StackPane stackPane = new StackPane();
	            TextArea text = new TextArea();
	            Collections.sort(orders);
	            String out = "";
	            for(int i = 0;i<orders.size();i++){
	                out+="name: "+orders.get(i).getCustomerName()+"\ntotal: "+orders.get(i).calculateOrderPrice()+" NIS"+"\n\n\n";
	            }
	            
	            text.setText(out);
	            text.setEditable(false);
	            stackPane.getChildren().add(text);
	            stackPane.setAlignment(Pos.CENTER);
	            stackPane.setPadding(new Insets(10));
	            Scene scene2 = new Scene(stackPane,400,400);
	            secStage.setScene(scene2);
	            secStage.setTitle("Purchases Report");
	            secStage.show();
	        });
			
			
			ProcessOrder.setOnAction(e -> {
				String name = customernm.getText();
			
				int Size;
	            if(pzSize.getValue().equals("Small"))
	                Size = 1;
	            else if (pzSize.getValue().equals("Medium"))
	                Size = 2;
	            else
	                Size = 3;
	            int topCnt = 0;
	            for(int i = 0; i<toptype.size();i++){
	                if(toptype.get(i).isSelected())
	                    topCnt++;
	            }

	            
	            double tpPrice = Double.parseDouble(topPrice.getText());


	            //Create object of the corresponding order type:

	            if(orderType.getValue().equals("To-Go")){
	                ToGo temp = new ToGo(name,Size,topCnt,tpPrice);
	                orders.add(temp);
	                orderPrice.setText(temp.calculateOrderPrice()+" ");
	            } else if (orderType.getValue().equals("Delivery")) {
	               // Integer zoone = Integer.parseInt(tzone.getText());
	              //  Double rate = Double.parseDouble(trip.getText());
	                Delivery temp = new Delivery(name,Size,topCnt,tpPrice, Double.parseDouble(trip.getText()), Integer.parseInt(tzone.getText()));
	                orders.add(temp);
	                orderPrice.setText(temp.calculateOrderPrice()+" ");
	            }else {
	                //Integer pplCounnt = Integer.parseInt(num.getText());
	             //  Double charge = Double.parseDouble(sevice.getText());
	                Seated temp = new Seated(name,Size,topCnt,tpPrice, Double.parseDouble(sevice.getText()),  Integer.parseInt(num.getText()));
	                orders.add(temp);
	                orderPrice.setText(temp.calculateOrderPrice()+" ");
				
	            }});
			//creating the new stage for the button print
			Stage printSt = new Stage();
			printSt.setTitle("second stage : the print stage");
	Reset.setOnAction((ActionEvent e) -> {
		orderType.getSelectionModel().select(0);
		customernm.setText("");
		numofppl.setText("");
		sevice.setText("");
		tzone.setText("");
		trip.setText("");
		del.setVisible(false);
		seat.setVisible(false);
		 for (int i = 0; i< toptype.size();i++){
             toptype.get(i).setSelected(false);
         }
		 orders.clear();
		
	});
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
}
