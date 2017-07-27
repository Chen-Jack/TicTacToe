/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Scoreboard {
    private static GridPane layout = new GridPane();
    
    public static GridPane initAndGet(){
        //layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(50);
        
        
        layout.add(new Label(Operation.getPlayer1().name), 0, 0);
        layout.add(new Label(Operation.getPlayer2().name), 1, 0);
        layout.add(new Label("0"), 0, 1);
        layout.add(new Label("0"), 1, 1);
        
        return layout;
    }
    
    public static void  updateP1Score(){
        ObservableList<Node> temp = layout.getChildren();
        ((Label)temp.get(2)).setText(Operation.getPlayer1().score.toString());
    }
    
    public static void updateP2Score(){
        ObservableList<Node> temp = layout.getChildren();
       ((Label)temp.get(3)).setText(Operation.getPlayer1().score.toString());
        
    }
}
