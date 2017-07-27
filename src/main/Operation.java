package main;

//This class does stuff like print the winner, reset the board, and keeps

//track of the score board.

public class Operation{ 
    private static Player p1;
    private static Player p2;
    private static Player currentPlayer;
    private static Integer turn;
    
    public static void initOperation(){
        p1 = new Player();   
        p2 = new Player();
        p1.symbol = "X";
        p2.symbol = "O";
        currentPlayer = p1;       //X goes first by default
        turn = 0;
    }
        
    public static void switchCurrentPlayer(){
        if(currentPlayer == p1){
            currentPlayer = p2;
        }
        else{
            currentPlayer = p1;
        }   
    }
    
    public static Player getPlayer1(){
        return p1;
    }
    
    public static Player getPlayer2(){
        return p2;
    }
    
    public static Player getCurrentPlayer(){
        return currentPlayer;
    }    
    
    public static Integer getTurn(){
        return turn;
    }
    
    public static void incrementTurn(){
        turn += 1;
    }
    
    public static void resetTurn(){
        turn = 0;
    }
    
    public static void setP1Name(String name){
        p1.name = name;
    }
    
    public static void setP2Name(String name){
        p2.name = name;
    }
}
