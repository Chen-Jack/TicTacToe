/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class WinCondition {
    public static <GridPane extends Pane> void check(GridPane board, Player[] roster){    

        checkHorizontalWin(board, roster);
        checkVerticalWin(board, roster);
        checkDiagonalWin(board, roster);
        
    }
    
    private static <GridPane extends Pane> void checkVerticalWin(GridPane board, Player[] roster){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
                
        for(Player player : roster){
            for(int i=0;i<3;i++){
                if(boardState[i].getText().equals(player.symbol)){
                    if(boardState[i+3].getText().equals(player.symbol)){
                        if(boardState[i+6].getText().equals(player.symbol)){
                            player.score++;
                            VictoryWindow.display(board, player);                       
                        }
                    }
                }
            }
        }        
    }
    
    private static <GridPane extends Pane> void checkHorizontalWin(GridPane board, Player[] roster){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        
        for(Player player : roster){
            for(int i=0; i<9; i+=3){
                if(boardState[i].getText().equals(player.symbol)){
                    if(boardState[i+1].getText().equals(player.symbol)){
                        if(boardState[i+2].getText().equals(player.symbol)){
                            player.score++;
                            VictoryWindow.display(board, player);  
                        }
                    }
                }
            }
        }
    }
    
    private static <GridPane extends Pane> void checkDiagonalWin(GridPane board, Player[] roster){
        ObservableList<Node> buttonList = board.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        
        for(Player player: roster){
            if(boardState[0].getText().equals(player.symbol)){
                if(boardState[4].getText().equals(player.symbol)){
                    if(boardState[8].getText().equals(player.symbol)){
                        player.score++;
                        VictoryWindow.display(board, player); 
                    }
                }

            }
            if(boardState[6].getText().equals(player.symbol)){
                if(boardState[4].getText().equals(player.symbol)){
                    if(boardState[2].getText().equals(player.symbol)){
                        VictoryWindow.display(board, player); 
                    }
                }
            }
        }
    }    
}
