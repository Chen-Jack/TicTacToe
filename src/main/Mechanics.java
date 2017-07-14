package main;

//This class does stuff like print the winner, reset the board, and keeps

import java.util.function.BiConsumer;
import javafx.scene.control.Button;

//track of the score board.

public class Mechanics {
    private Player p1;
    private Player p2;
    private Player currentPlayer ;
    
    Mechanics(){
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
    
    /*
    public void check(Button[] buttonArray, Player player, BiConsumer<Button[],Player> func){
        func.accept(buttonArray, player);
    }*/
    
}
