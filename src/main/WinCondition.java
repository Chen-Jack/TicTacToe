package main;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class WinCondition {
    public static <GridPane extends Pane> void check(GridPane board, Player player){    

        checkHorizontalWin(board, player);
        checkVerticalWin(board, player);
        checkDiagonalWin(board, player);
        checkTie();
        
    }
    
    private static <GridPane extends Pane> void checkVerticalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);

        for(int i=0;i<3;i++){
            if(boardState[i].getText().equals(player.symbol)){
                if(boardState[i+3].getText().equals(player.symbol)){
                    if(boardState[i+6].getText().equals(player.symbol)){
                        player.score++;
                        VictoryWindow.display(player);                       
                    }
                }
            }
        }

    }
    
    private static <GridPane extends Pane> void checkHorizontalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);

        for(int i=0; i<9; i+=3){
            if(boardState[i].getText().equals(player.symbol)){
                if(boardState[i+1].getText().equals(player.symbol)){
                    if(boardState[i+2].getText().equals(player.symbol)){
                        player.score++;
                        VictoryWindow.display(player);  
                    }
                }
            }
        }
        
    }
    
    private static <GridPane extends Pane> void checkDiagonalWin(GridPane board, Player player){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        
        if(boardState[0].getText().equals(player.symbol)){
            if(boardState[4].getText().equals(player.symbol)){
                if(boardState[8].getText().equals(player.symbol)){
                    player.score++;
                    VictoryWindow.display(player); 
                }
            }

        }
        if(boardState[6].getText().equals(player.symbol)){
            if(boardState[4].getText().equals(player.symbol)){
                if(boardState[2].getText().equals(player.symbol)){
                    VictoryWindow.display(player); 
                }
            }
        }     
    }    
    
    private static void checkTie(){
        if(Operation.getTurn() == 9){
            VictoryWindow.display(new Player("No One"));
        }
    }
}
