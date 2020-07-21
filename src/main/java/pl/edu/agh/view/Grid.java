package pl.edu.agh.view;

import javafx.scene.layout.Pane;

public class Grid extends Pane {
    private final int rows;
    private final int columns;
    private final double width;
    private final double height;

    public Grid( int columns, int rows, double width, double height) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
    }

    public void add(Cell cell) {
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
}
