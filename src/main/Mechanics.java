package main;

//This class does stuff like print the winner, reset the board, and keeps
//track of the score board.

public class Mechanics {
    Player p1;
    Player p2;
    Player currentPlayer ;
    
    Mechanics(){
        p1 = new Player();
        p2 = new Player();
        p1.symbol = 'X';
        p2.symbol = 'O';
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
    
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
}
