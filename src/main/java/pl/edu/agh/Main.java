package pl.edu.agh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pl.edu.agh.view.BoardScene;

public class Main extends Application {

    double width = 800;
    double height = 800;

    @Override
    public void start(Stage stage) {
        Scene scene = new BoardScene(new HBox(), width, height);
        stage.setScene(scene);
        stage.show();
    }
}
