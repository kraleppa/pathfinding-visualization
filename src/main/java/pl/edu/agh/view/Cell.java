package pl.edu.agh.view;

import javafx.scene.layout.StackPane;
import lombok.Getter;
import pl.edu.agh.logic.util.Vertex;

import java.awt.*;
import java.beans.EventHandler;

@Getter
public class Cell extends StackPane {
    private Vertex vertex;

    public Cell(Vertex vertex) {
        super();
        this.vertex = vertex;

        this.setStyle("-fx-border-color: dodgerblue; -fx-border-width: 1px;");
        this.setOpacity(0.9);
    }

    public void paint(){
        this.getStyleClass().clear();
        this.setStyle("-fx-background-color: blue");
    }


}
