package main;

//This class does stuff like print the winner, reset the board, and keeps
//track of the score board.

public class Mechanics {
    
    final String p1name;               //names of the players
    final String p2name;
    public enum Player{X, O};
    Player currentPlayer ;
    
    Mechanics(){
        p1name = "P1" ; 
        p2name = "P2";      
        currentPlayer = Player.X;       //X goes first by default
  
    }
        
    public void switchCurrentPlayer(){
        if(currentPlayer == Player.X){
            currentPlayer = Player.O;
        }
        else{
            currentPlayer = Player.X;
        }
    
    }
    
    //Returns an array of the two players;
    /*
    public void getPlayers(){
        return player1;
    }*/
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
}
