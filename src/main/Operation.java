package main;

//This class does stuff like print the winner, reset the board, and keeps

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


//track of the score board.

public class Operation{ 
    private final Player p1;
    private final Player p2;
    private Player currentPlayer;
    
    Operation(){
        p1 = new Player("Jack", "X");
        p2 = new Player("Ana", "O");
        p1.symbol = "X";
        p2.symbol = "O";
        currentPlayer = p1;       //X goes first by default
    }
        
    public void switchCurrentPlayer(){
        if(currentPlayer == p1){
            currentPlayer = p2;
        }
        else{
            currentPlayer = p1;
        }   
    }
    
    public Player[] getPlayers(){
        Player[] playersArray = new Player[2];
        playersArray[0] = p1;
        playersArray[1] = p2;
        return playersArray;
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }    
    
        
    public <GridPane extends Pane> void setButtonFunction(GridPane board){
        ObservableList<Node> buttonList = board.getChildren();
        
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button button = (Button)iterator.next();
            button.setMinSize(50, 50);
            button.setOnAction(e -> {
                button.setText(currentPlayer.symbol);
                button.setMouseTransparent(true);
        
                WinCondition.check(board, getPlayers());
                switchCurrentPlayer();


               
            });
        }
        
    }
}
