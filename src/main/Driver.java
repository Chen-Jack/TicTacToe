package main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Driver extends Application{
    
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Tic-Tac-Toe");
       
        
        Scene scene = new Scene(new GameLayout().createGameLayout());
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
        
    }
    
}
