package main;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameLayout {
    //Requires that boardInit be already called beforehand.
    public static VBox initGameLayout(){
             
        VBox layout = new VBox();
        
        GridPane scoreboard = new GridPane();
        scoreboard.setPadding(new Insets(10,10,10,10));
        scoreboard.setHgap(50);
        
        
        scoreboard.add(new Label("Player 1"), 0, 0);
        scoreboard.add(new Label("Player 2"), 1, 0);
        scoreboard.add(new Label("3"), 0, 1);
        scoreboard.add(new Label("0"), 1, 1);
        
        GridPane gameBoard = Board.getBoard();
        
        layout.getChildren().add(scoreboard);
        layout.getChildren().add(gameBoard);
        
        return layout;
    }
}
