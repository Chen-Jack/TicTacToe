package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

//class for displaying the end game screen. Either to reset or close the game.

public class VictoryWindow{
    public static void display(Player winningPlayer){
        Stage stage = new Stage();
        stage.setTitle("Game Over");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        VBox layout = new VBox();
        

        Label label = new Label (winningPlayer.name + " won!");
        label.setPadding(new Insets(10,10,10,10));
        label.setFont(new Font(16));
        
        
        HBox choices = new HBox();
        choices.setPadding(new Insets(10, 10, 10, 10));
        choices.setSpacing(10);
        
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction((event) -> {
            System.out.println("Inset resetfunction");
        });
        choices.getChildren().add(0, newGameButton);

        
        
        Button closeGameButton = new Button ("Close Game");
        closeGameButton.setOnAction((event) -> {
            System.out.println("Close");
        });
        choices.getChildren().add(1, closeGameButton);
        
        
        layout.getChildren().add(0, label);
        layout.getChildren().add(1, choices);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }   
}
