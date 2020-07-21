package pl.edu.agh.view;

import javafx.scene.layout.Pane;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vector2D;

import java.util.HashMap;
import java.util.Map;

public class Grid extends Pane {
    private int rows;
    private int columns;
    private double width;
    private double height;

    private Map<Vector2D, Cell> cells = new HashMap<>();

    public Grid( int columns, int rows, double width, double height) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
    }

    public void add(Cell cell) {

        cells.put(cell.getVertex().getPosition(), cell);

        double w = width / columns;
        double h = height / rows;
        double x = w * cell.getVertex().getPosition().getX();
        double y = h * cell.getVertex().getPosition().getY();

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setPrefWidth(w);
        cell.setPrefHeight(h);

        getChildren().add(cell);
    }

    public void refresh(){
        this.cells.values().forEach((cell -> {
            if (cell.getVertex().getState() == State.VISITED){
                cell.updateVisited();
            }
        }));
    }
}
