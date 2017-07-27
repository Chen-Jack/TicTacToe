package main;

import javafx.scene.layout.VBox;


//The class that connects all other classes together
public class Game {
    private static VBox mainGameLayout;
    
    public static void initGame(){
        
        Board.initBoard();
        Operation.initOperation();
        
        promptName();  //This method requires operation to be initialized first.
        
        //Generating the complete game layout and functionality.
        mainGameLayout = GameLayout.initGameLayout();
    }
    
    private static void promptName(){
        OpenScreen.promptName();
    }
    
    public static VBox getGameLayout(){
        return mainGameLayout;
    }

    
}
