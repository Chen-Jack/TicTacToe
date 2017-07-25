package main;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class WinCondition {
    public static <GridPane extends Pane> void check(GridPane board, 
            Player player1, Player player2){    

        if(checkHorizontalWin(board, player1)||
            checkVerticalWin(board, player1)||
            checkDiagonalWin(board, player1)){
                player1.score += 1;
                VictoryWindow.display(player1);
            }
        else if(checkHorizontalWin(board, player2)||
            checkVerticalWin(board, player2)||
            checkDiagonalWin(board, player2)){
                player2.score += 1;
                VictoryWindow.display(player2);
            }
        else if(checkTie()){
            VictoryWindow.display(new Player("No one"));
        }   
    }
    
    private static <GridPane extends Pane> boolean checkVerticalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);

        for(int i=0;i<3;i++){
            if(boardState[i].getText().equals(player.symbol)){
                if(boardState[i+3].getText().equals(player.symbol)){
                    if(boardState[i+6].getText().equals(player.symbol)){
                        return true;  
                    }
                }
            }
        }
        //If the above for loop doesnt return true, method defaults to false.
        return false;
    }
    
    private static <GridPane extends Pane> boolean checkHorizontalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);

        for(int i=0; i<9; i+=3){
            if(boardState[i].getText().equals(player.symbol)){
                if(boardState[i+1].getText().equals(player.symbol)){
                    if(boardState[i+2].getText().equals(player.symbol)){
                        return true;
                    }
                }
            }
        }
        //If the above for loop doesnt return true, method defaults to false.
        return false;
    }
    
    private static <GridPane extends Pane> boolean checkDiagonalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        
        if(boardState[0].getText().equals(player.symbol)){
            if(boardState[4].getText().equals(player.symbol)){
                if(boardState[8].getText().equals(player.symbol)){
                    return true;
                }
            }

        }
        if(boardState[6].getText().equals(player.symbol)){
            if(boardState[4].getText().equals(player.symbol)){
                if(boardState[2].getText().equals(player.symbol)){
                    return true;
                }
            }
        }  
        
        //If the above for loops doesnt return true, method defaults to false.
        return false;
    }    
    
    private static boolean checkTie(){
        return Operation.getTurn() == 9;
    }
}
