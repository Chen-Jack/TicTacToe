package main;

//Player struct that contains each players attributes

public class Player {
    public String name;
    int score;
    String symbol;              
    boolean currentPlayer;
    
    Player(String name, String symbol){
        this.name = name;
        this.score = 0;
        this.symbol = symbol;
    }
    
    Player(String name){
        this.name = name;
    }
    
}
