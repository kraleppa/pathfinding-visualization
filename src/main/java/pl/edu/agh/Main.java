package pl.edu.agh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.edu.agh.view.BoardScene;

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
