package pl.edu.agh.view;

import javafx.scene.layout.StackPane;

import java.awt.*;
import java.beans.EventHandler;

public class Cell extends StackPane {
    int column;
    int row;

    public Cell(int column, int row) {
        super();
        this.column = column;
        this.row = row;

        this.setStyle("-fx-border-color: dodgerblue; -fx-border-width: 1px;");
        this.setOpacity(0.9);
    }

    public void paint(){
        this.getStyleClass().clear();
        this.setStyle("-fx-background-color: blue");
    }


}
