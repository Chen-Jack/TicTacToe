package main;

//Player struct that contains each players attributes

public class Player {
    public String name;
    int score;
    String symbol;              
    boolean currentPlayer;
    
    Player(String name, String symbol){
        this.name = name;
        score = 0;
        this.symbol = symbol;
    }
}
