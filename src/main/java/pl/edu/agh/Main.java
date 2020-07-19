package pl.edu.agh;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.view.BoardScene;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new BoardScene(new Pane(), 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
