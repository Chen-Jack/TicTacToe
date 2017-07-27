package main;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

//Class for displaying the end game screen. (Either to reset or close the game)
//The window is a label (showing the winner) on top, and horizontal buttons
//(to choose whether to reset the game), on the bottom.

public class VictoryWindow{
    public static  void display(Player winningPlayer){
        Stage stage = new Stage();
        stage.setTitle("Game Over");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        /*
        if(winningPlayer == Operation.getPlayer1()){
            Scoreboard.updateP1Score();
        }
        else if(winningPlayer == Operation.getPlayer2()){
            Scoreboard.updateP2Score();
        }*/
        
        
        VBox layout = new VBox();
        
        //Top half of window (Just a label)
        Label label = new Label (winningPlayer.name + " won!");
        label.setPadding(new Insets(10,10,10,10));
        label.setFont(new Font(16));
        
        layout.getChildren().add(0, label);       //Adding the label to layout

        //Bottom half of window (Nested HBox)
        HBox choices = new HBox();
        choices.setPadding(new Insets(10, 10, 10, 10));
        choices.setSpacing(10);
        
        Button newGameButton = new Button("New Game");  //Button 1
        newGameButton.setOnAction((event) -> {
            Operation.resetTurn();
            Board.clearBoard();
            stage.close();
        });
       
        Button closeGameButton = new Button ("Close Game"); //Button 2
        closeGameButton.setOnAction((event) -> {
            Platform.exit();
        });
        
        choices.getChildren().add(0, newGameButton);    //Adding buttons to HBox
        choices.getChildren().add(1, closeGameButton);
        
        
        layout.getChildren().add(1, choices); //Adding the nested HBox to layout
        
        
        //Setting the scene
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }   
}
