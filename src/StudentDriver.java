import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class StudentDriver extends Application{
/**
 * Author: Karl Lyttek
 * date created: 11/17/15
 * Purpose, averaging four grades and a student's name
 */
	public static void main(String[] args) {
		 launch(args);
		//launches the javaFX application
	}
	
	@Override
	public void start(Stage primaryStage) {	
		Text output = new Text("Output: ");
		Text nameT = new Text("");
		//both the above Textfields are for output to be viewed by the user
		Label title = new Label("Enter the student's grades and name below");
		Label grade1 = new Label("Enter the first grade here:");
		Label grade2 = new Label("Enter the second grade here:");
		Label grade3 = new Label("Enter the third grade here:");
		Label grade4 = new Label("Enter the fourth grade here:");
		Label name = new Label("Enter the Student's name:");
		//the above are all the labels for the gridPane
		TextField num1 = new TextField();
		TextField num2 = new TextField();
		TextField num3 = new TextField();
		TextField num4 = new TextField();
		TextField sName = new TextField();
		//The above are all the Textfields for the gridPane
		Button calculate = new Button("Average");
		//The above is the only button in the application, starts the action event below
		
		calculate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

		//The action event's calculations begin below
	
	String numA, numB, numC, numD, name1;
		//Initializes Strings
	int numb1,numb2,numb3,numb4;
		//initializes integers
		numA = num1.getText();
		numB = num2.getText();
		numC = num3.getText();
		numD = num4.getText();
		//converts TextFields to Strings
		name1 = ("Student: " + sName.getText());
		//converts name Textfield to String
		numb1 = Integer.parseInt(numA);
		numb2 = Integer.parseInt(numB);
		numb3 = Integer.parseInt(numC);
		numb4 = Integer.parseInt(numD);
		//converts Strings into int values
		
		double[] assignments = {numb1, numb2, numb3, numb4};
		//creates the array used in the new Student below
		
		
		Student student = new Student(name1, assignments);
	
		
		output.setText("Their grade is: " + student.getGpa());
		nameT.setText(student.getName());
			//the above two "setText"s show the output of the user's input
			}
		});
		
		GridPane grid = new GridPane();
		//creates the GridPane "grid"
		grid.setAlignment(Pos.TOP_LEFT);
		//Positions "grid" to the top left
		grid.setVgap(40);
		//sets the vertical gap between fields
		grid.setHgap(0);
		//sets the horizontal gap between fields
		
		grid.add(title, 0, 0);
		grid.add(grade1, 0, 1);
		grid.add(num1, 1, 1);
		grid.add(grade2, 0, 2);
		grid.add(num2, 1, 2);
		grid.add(grade3, 0, 3);
		grid.add(num3, 1, 3);
		grid.add(grade4, 0, 4);
		grid.add(num4, 1, 4);
		grid.add(name, 0, 5);
		grid.add(sName, 1, 5);
		grid.add(calculate, 1, 6);
		grid.add(output, 2, 7 );
		grid.add(nameT, 1, 7);
		//The above adds all fields, text and Label
		
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
