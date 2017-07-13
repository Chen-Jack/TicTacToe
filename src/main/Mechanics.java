package main;

//This class does stuff like print the winner, reset the board, and keeps
//track of the score board.

public class Mechanics {
    
    final String player1;               //names of the players
    final String player2;
    String currentPlayer;
    public enum Turn{"X", "O"};
    Turn currentTurn;
    
    Mechanics(){
        player1 = "P1" ; 
        player2 = "P2";      
        currentTurn = (Turn)"X";       //player1 goes first by default
  
    }
        
    public void switchCurrentPlayer(){
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
    
    }
    
    //Returns an array of the two players;
    public void getPlayers(){
        return player1;
    }
       
    public String getTurn(){
        return 
    }
}
