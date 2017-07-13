package main;


import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.Node;



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
