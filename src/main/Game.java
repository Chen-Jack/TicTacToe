package main;

import javafx.scene.layout.VBox;


//The class that connects all other classes together
public class Game {
    private static VBox mainGameLayout;
    
    public static void initGame(){
        Board.initBoard();
        Operation.initOperation();
        mainGameLayout = GameLayout.initGameLayout();
    }
    
    public static VBox getGameLayout(){
        return mainGameLayout;
    }
    
}
