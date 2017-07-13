package main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class Driver extends Application{
    
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Tic-Tac-Toe");
        
        GridPane layout = new Board().createBoard();
        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);
        primaryStage.show();
        
       
        
    }
    
}
