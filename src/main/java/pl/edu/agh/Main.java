package pl.edu.agh;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.view.BoardScene;
import pl.edu.agh.view.Cell;
import pl.edu.agh.view.Grid;
import pl.edu.agh.view.MouseGestures;

public class Main extends Application {
    int rows = 15;
    int columns = 20;
    double width = 800;
    double height = 600;

    @Override
    public void start(Stage stage) throws Exception {
//        Scene scene = new BoardScene(new Pane(), 400, 400);
//        stage.setScene(scene);
//        stage.show();

        StackPane root = new StackPane();
        Grid grid = new Grid( columns, rows, width, height);

        MouseGestures mg = new MouseGestures();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = new Cell(column, row);

                mg.makePaintable(cell);

                grid.add(cell, column, row);
            }
        }
        root.getChildren().addAll(grid);
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
