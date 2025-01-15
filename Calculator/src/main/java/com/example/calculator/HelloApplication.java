package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vbox=new VBox();
        vbox.setPadding(new Insets(5,5,5,5));
        vbox.setAlignment(Pos.CENTER);



        HBox hbox2=new HBox(5);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setPadding(new Insets(2,2,2,2));
        Text n1 = new Text("Number 1:");  //or Textfield n1=new Textfield();  n1.setPromptText("Number 1");
        TextField f1 = new TextField();
        Text n2 = new Text("Number 2:");
        TextField f2 = new TextField();
        Text res = new Text("Result:");
        TextField f3 = new TextField();
        hbox2.getChildren().addAll(n1,f1,n2,f2,res,f3);

        HBox hbox1=new HBox(5);
        hbox1.setPadding(new Insets(2,2,2,2));
        hbox1.setAlignment(Pos.CENTER);
        Button add = new Button("Add");
        Button subtract = new Button("Subtract");
        Button divide = new Button("Divide");
        Button multiply = new Button("Multiply");
        hbox1.getChildren().addAll(add,subtract,multiply,divide);

        add.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(f1.getText());   //try catch for error handling
                double num2 = Double.parseDouble(f2.getText());
                double result = num1 + num2;
                f3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {   //ex is a variabel that represents the exception object
                f3.setText("invalid input");
            }
        });

        subtract.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(f1.getText());
                double num2 = Double.parseDouble(f2.getText());
                double result = num1 - num2;
                f3.setText(String.valueOf(result));
            }catch(NumberFormatException  ex){
                f3.setText("invalid input");
            }

        });

        multiply.setOnAction(e->{
            try {
                Double num1 = Double.parseDouble(f1.getText());
                Double num2 = Double.parseDouble(f2.getText());
                double result = num1 * num2;
                f3.setText(String.valueOf(result));
            }catch(NumberFormatException ex){
                f3.setText("invalid input");
            }

        });

        divide.setOnAction(e->{
            try{
                Double num1=Double.parseDouble(f1.getText());
                Double num2=Double.parseDouble(f2.getText());
                if(num2!=0){
                    double result=num1/num2;
                    f3.setText(String.valueOf(result));
                }
                else{
                    f3.setText("cannot divide by zero");
                }
            }catch(NumberFormatException ex){
                f3.setText("invalid input");
            }
        });


        vbox.getChildren().addAll(hbox2,hbox1);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}