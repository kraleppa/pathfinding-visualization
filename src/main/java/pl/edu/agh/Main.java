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

    double width = 800;
    double height = 800;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new BoardScene(new StackPane(), width, height);
        stage.setScene(scene);
        stage.show();
    }
}
