package main;

import javafx.scene.layout.VBox;

public class GameLayout {
    private static VBox layout;
    
    public static VBox initGameLayout(){
             
        layout = new VBox();
        
        //Upper Half: The score board;
        layout.getChildren().add(Scoreboard.initAndGet());

        //Lower Half: The gameboard
        layout.getChildren().add(Board.getBoard());
        
        return layout;
    }
}
