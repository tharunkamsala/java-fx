package sravyaa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;
//ABSTRACT CLASS
abstract class Base {
  abstract void fun();
}
class Derived extends Base {
  void fun()
  {
      System.out.println("PLAY OUR RESTARUANT GAME -------GUESS AND WIN................! ");
  }
}
////SIMPLE INHERITANCE
class one {
	public void print_1()
	{
		System.out.println("**get a coupon in the counter show next time to eat freeee....!***");
	}
}

class two extends one {
	public void print_2() { System.out.println("buy one get one free for want ever u order for only one item..............!!!!!!"); }
}


  

public class restaurant extends Application
{
	public static void main(String[] args)
	{
			launch(args);
		
}
	public void init()
	{ Base b = new Derived();
  b.fun();
		 System.out.println("***select one number from the following to test ur luck***");
	     System.out.println("1 2 3 4 5 ");
	     Scanner sc=new Scanner(System.in);
	     System.out.println("enter the no u have choosen");
	     int num=sc.nextInt();
	     sc.close();
	   
	     if(num==1) {
	    	 two g = new two();
	    	 g.print_1();
	     }
	     if(num==2)
		{ two g = new two();
		g.print_2();
		}
	     if(num==3)
			{
				System.out.println("sorry..........try again on next visit.......");
			}
	     if(num==4)
			{
				System.out.println("sorry......try again on next visit.......");
			}
			if(num==5)
			{
				System.out.println("sorry....try again on next visit.......");
			}
		}

	public void start(Stage myStage)
	
	throws Exception
	    
	
	{   //set the title of a stage. 
		myStage.setTitle("*****RESTAURANT MANAGEMENT SYSTEM*****");
			//not to make all boxes merge into one
	        VBox root=new VBox();
	        
	        
	      //for reading the textfield input.
			Text t1=new Text("Name of CUSTOMER");
			TextField tf1=new TextField();
			
			Text t2=new Text("PHONE NO  OF CUSTOMER");
			TextField tf2=new TextField();
			
			Text t3=new Text("veg item name");
			TextField tf3=new TextField();
			
			Text t4=new Text("veg item  cost");
			TextField tf4=new TextField();
			
			Text t5=new Text("non-veg item name");
			TextField tf5=new TextField();
			
			Text t6=new Text("non-veg item cost");
			TextField tf6=new TextField();
			
			
			Text t11=new Text("special item name");
			TextField tf11=new TextField();
			
			Text t12=new Text("special item  cost");
			TextField tf12=new TextField();
		
		
			
			
			//lighting effect in javafx
			Text t100=new Text();
			t100.setStyle("-fx-font:normal bold 22px 'serif'");
			t100.setText("LAUGHTER IS BRIGHTEST WHERE FOOD IS BEST.......!!");
			t100.setFill(Color.YELLOW);
			Lighting lig=new Lighting();
			t100.setEffect(lig);
			
			
			  
			
			Text t7=new Text("select quantity of veg item ");
			Text t8=new Text("select quantity of  nonveg item ");
			
			
			//combobox in javafx.
	        String quantity[] = { "none","onebyfour","half", "one", "two","three", "four","five" };
	        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(quantity));
	        Label selected = new Label("default item selected");
	        
	        
	        String quantity1[] = { "none","onebyfour","half", "one", "two","three", "four","five" };
	        ComboBox combo_box1 = new ComboBox(FXCollections.observableArrayList(quantity1));
	        Label selected1 = new Label("default item selected");

	        
	        String quantity11[] = { "none","onebyfour","half", "one", "two","three", "four","five" };
	        ComboBox combo_box11 = new ComboBox(FXCollections.observableArrayList(quantity11));
	        //a label to identify which item is selected in combobox.
	        Label selected11 = new Label("default item selected");  
	        //buttons in javafx.
			Button show= new Button("click on to show menu for veg ");
			Button show1= new Button("click on to show menu for non- veg ");
			Button b=new Button("submit");
			Button show2=new Button("click on me for SPECIAL MENU");
			
			//imageview in javafx.
			ImageView mainpage = new ImageView("Indian-Food-wikicont.jpg");
			mainpage.setX(100);
			mainpage.setY(100);
			
			mainpage.setFitHeight(200);
			mainpage.setFitWidth(1300);
			
			//action to take place when button submit is clicked.
			b.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					String str1=tf1.getText();
		            String str2=tf2.getText();
		            String str3=tf3.getText();
		            String str4=tf4.getText();
		            String str5=tf5.getText();
		            String str6=tf6.getText();
		            String str17=tf11.getText();
		            String str18=tf12.getText();
		           
		            
		            
		            selected.setText(combo_box.getValue() + " ");
		            selected1.setText(combo_box1.getValue() + " ");
		            String str7=selected.getText();
		            String str8=selected1.getText();
		            
		            
		            
		            
		            selected11.setText(combo_box11.getValue() + " ");
		            String str21=selected11.getText();
		          
		            
		            //connection with jdbc .
		            
		            
		            Connection con;
		            Statement stmt=null;
		            try
		        	{    //STEP1:REGISTERING FOR DRIVER
		        		
		        		Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
		        		
		        		
		        		//STEP2:CONNECTING
		        	  final String user="root";
		        	  final String pass="ramathulasi";
		        	  final String db_url="jdbc:mysql://127.0.0.1:3306/ project_java";
		        	  con=DriverManager.getConnection(db_url,user,pass);
		        	    
		        	  
		        	  //STEP3:STATEMENT
		            stmt=(Statement) con.createStatement();
		        	
	               //Step 4 execute query-insert into table
		            //Insert INTO table1 values('"+str1+"','"+str2+"');
		            
		            System.out.println("READING the values into user");
		            int row=stmt.executeUpdate("Insert INTO user values('"+str1+"','"+str2+"');");
		            System.out.println("Inserting the values into user");
		            System.out.println("Name: phoneno");
		            ResultSet rs=stmt.executeQuery("select *from user");
		            while(rs.next())
		            {
		            	System.out.println(" "+rs.getString(1)+":"+rs.getLong(2));
		            }
		            
		            
		            System.out.println("READING the values into table1");
		            int row1=stmt.executeUpdate("Insert INTO table1 values('"+str3+"','"+str4+"','"+str7+"')");
		            
		            System.out.println("Inserting the values into table1");
		            System.out.println("sucessfully taken ur order........!!");
		            ResultSet rs1=stmt.executeQuery("select *from table1");
		            
		            
		            
		            
		            
		            System.out.println("READING the values into table2");
		            int row2=stmt.executeUpdate("Insert INTO table2 values('"+str5+"','"+str6+"','"+str8+"')");
		            
		            System.out.println("Inserting the values into table2");
		            System.out.println("sucessfully taken ur order...................!!");
		            ResultSet rs2=stmt.executeQuery("select *from table2");
		            
		            
		            
		            
		            
		            System.out.println("READING the values into tablei");
		            int row22=stmt.executeUpdate("Insert INTO tablei values('"+str17+"','"+str18+"','"+str21+"')");
		            
		            System.out.println("Inserting the values into tablei");
		            System.out.println("sucessfully taken ur order...................!!");
		            ResultSet rs22=stmt.executeQuery("select *from tablei");
		  
		        	}catch(Exception e)
		        	{
		        		System.out.println("Error..!!");
		        	}
		        	}
			
		   
				});
		
			show.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {

				
				
				ImageView hourglassIV = new ImageView("menu-veg.jpg");
			
				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().addAll(show,hourglassIV);

				Scene secondScene = new Scene(secondaryLayout, 600, 600);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle(" VEG MENU");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(myStage.getX() + 200);
				newWindow.setY(myStage.getY() + 100);

				newWindow.show();
				}
				});
			//when u click on button it will display image.
			show1.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
				
				ImageView hourglassIV = new ImageView("non-veg menu.jpeg");
			
				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().addAll(show1,hourglassIV);

				Scene secondScene = new Scene(secondaryLayout, 600, 600);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle(" NON VEG MENU");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(myStage.getX() + 200);
				newWindow.setY(myStage.getY() + 100);

				newWindow.show();
				}
				});
			show2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
				
				ImageView hourglassIV = new ImageView("special final.jpg");
			
				StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().addAll(show1,hourglassIV);

				Scene secondScene = new Scene(secondaryLayout, 600, 600);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle(" SPECIAL MENU");
				newWindow.setScene(secondScene);

				// Set position of second window, related to primary window.
				newWindow.setX(myStage.getX() + 200);
				newWindow.setY(myStage.getY() + 100);

				newWindow.show();
				}
				});
			
			root.getChildren().addAll(t100,t1,tf1,t2,tf2,show,show1,show2,t3,tf3,t4,tf4,t7,combo_box,selected,t5,tf5,t6,tf6,t8,combo_box1,selected1,t11,tf11,t12,tf12,combo_box11,selected11,b,mainpage);
			Scene sc=new Scene(root,600,600);
			myStage.setScene(sc);
			myStage.show();
	}
	public void stop()
	{   try
	{    //STEP1:REGISTERING FOR DRIVER
		
		Class c2=Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		//STEP2:CONNECTING
	  final String user="root";
	  final String pass="ramathulasi";
	  final String db_url="jdbc:mysql://127.0.0.1:3306/project_java";
	  Connection con=DriverManager.getConnection(db_url,user,pass);
	    
	  
	  //STEP3:STATEMENT
  Statement stmt=(Statement) con.createStatement();
  //STEP4:EXECUTE QUERY
   ResultSet rs=stmt.executeQuery("select *from tableinfo");
   System.out.println("CHEF & SERVANT INFORMATION");
   while(rs.next())
   {
  	 System.out.println("sl_no: "+rs.getInt(1)+"     Name: "+rs.getString(2)+"          noofyofserivce: "+rs.getString(3)+      "goodat:"+rs.getString(4)+"       chef  or servant::"+rs.getString(5));
   }
  
	}
	catch(Exception e)
	{
		System.out.println("Error..!!");
	}

	}
	}