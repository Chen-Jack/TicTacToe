package main;


import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.Node;



public class Driver extends Application{
    final String player1 = "X";         //These three variables must be
    final String player2 = "O";         //kept at the global application
    String currentPlayer = player1;     //scope.
    int turn = 0;
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Tic-Tac-Toe");
        
        GridPane layout = createBoard();
        Scene scene = new Scene(layout);
        setButtonFunction(layout);

        primaryStage.setScene(scene);
        primaryStage.show();
        
       
        
    }
    
    public void switchCurrentPlayer(){
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
    
    }
    
    public GridPane createBoard(){
        GridPane layout = new GridPane();    
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(10);
        layout.setHgap(10);
                     
        for(int col = 0; col < 3; col++){             //row
            for(int row = 0; row < 3; row++){         //column                
                layout.add(new Button(" "), row, col);
            }
        }
        
        ObservableList<Node> buttonList = layout.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button buffer = (Button)iterator.next();
            buffer.setMinSize(50, 50);
        }
        return layout;
    }
    
    public <T extends Pane> void setButtonFunction(T scheme){
        ObservableList<Node> buttonList = scheme.getChildren();
        Iterator iterator = buttonList.iterator();
        while(iterator.hasNext()){
            Button buffer = (Button)iterator.next();
            buffer.setMinSize(50, 50);
            buffer.setOnAction(e -> {
                buffer.setText(currentPlayer);
                buffer.setMouseTransparent(true);
                checkBoard(scheme);
                switchCurrentPlayer();
            });
        }
        
    }
    
    public <T extends Pane> void checkBoard(T scheme){        
        ObservableList<Node> buttonList = scheme.getChildren();
        Button[] boardState = buttonList.toArray(new Button[9]);
        //Checking horizontal win
        checkHorizontalWin(boardState, player1);
        checkHorizontalWin(boardState, player2);
        checkVerticalWin(boardState,player1);
        checkVerticalWin(boardState,player2);
        checkDiagonalWin(boardState,player1);
        checkDiagonalWin(boardState,player2);
        
    }
    
    private void checkVerticalWin(Button[] buttonArray, String player){
        for(int i=0;i<3;i++){
            if(buttonArray[i].getText().equals(player)){
                if(buttonArray[i+3].getText().equals(player)){
                    if(buttonArray[i+6].getText().equals(player)){
                        System.out.println(player + " Won!");
                        
                    }
                }
            }
        }        
    }
    
    private void checkHorizontalWin(Button[] buttonArray, String player){
        for(int i=0; i<9; i+=3){
            if(buttonArray[i].getText().equals(player)){
                if(buttonArray[i+1].getText().equals(player)){
                    if(buttonArray[i+2].getText().equals(player)){
                        System.out.println(player + " Won!"); 
                    }
                }
            }
        }
    }
    
    private void checkDiagonalWin(Button[] buttonArray, String player){
        if(buttonArray[0].getText().equals(player)){
            if(buttonArray[4].getText().equals(player)){
                if(buttonArray[8].getText().equals(player)){
                    System.out.println(player + " Won!");
                }
            }
                
        }
        if(buttonArray[6].getText().equals(player)){
            if(buttonArray[4].getText().equals(player)){
                if(buttonArray[2].getText().equals(player)){
                    System.out.println(player + " Won!");
                }
            }
        }
    }


    
}
