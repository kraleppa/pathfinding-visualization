package pl.edu.agh.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pl.edu.agh.logic.algorithms.Algorithm;
import pl.edu.agh.logic.algorithms.BFS;
import pl.edu.agh.logic.algorithms.Dijkstra;
import pl.edu.agh.logic.board.Board;

public class OptionsPane extends VBox {
    private Button startButton;
    private Button clearButton;
    private Board board;
    private MouseGestures mouseGestures;
    private boolean ready = false;

    public OptionsPane(Board board, MouseGestures mouseGestures) {
        this.board = board;
        this.mouseGestures = mouseGestures;
        this.startButton = new Button("Save");
        this.startButton.setOnAction(onStartSaveClickEvent);

        this.clearButton = new Button("Clear");
        clearButton.setOnAction(onClearClickEvent);

        this.getChildren().addAll(this.startButton, clearButton);

        this.setStyle("-fx-padding: 10; -fx-alignment: top-center");
        this.setSpacing(10);
    }

    EventHandler<ActionEvent> onStartSaveClickEvent = event -> {
        if (!ready){
            if (this.mouseGestures.endIsPresent && this.mouseGestures.startIsPresent){
                this.startButton.setText("Start!");
                ready = true;
                this.mouseGestures.setCanModify(false);
            }
        } else {
            this.clearButton.setVisible(false);
            this.startButton.setVisible(false);
            Algorithm algorithm = new Dijkstra(this.board.getGraph());
            algorithm.start();
            Thread waitForEndThread = new Thread(() -> {
                try {
                    algorithm.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this){
                    this.clearButton.setVisible(true);
                }
            });

            waitForEndThread.start();

        }
    };

    EventHandler<ActionEvent> onClearClickEvent = event -> {
        this.board.resetGraph();
        this.mouseGestures.setCanModify(true);
        this.startButton.setVisible(true);
        this.startButton.setText("Save");
        this.ready = false;
        this.mouseGestures.setEndIsPresent(false);
        this.mouseGestures.setStartIsPresent(false);
    };
}
