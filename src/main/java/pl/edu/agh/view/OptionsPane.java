package pl.edu.agh.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import pl.edu.agh.logic.algorithms.Algorithm;
import pl.edu.agh.logic.algorithms.BFS;
import pl.edu.agh.logic.algorithms.Dijkstra;
import pl.edu.agh.logic.board.Board;

import java.util.List;

public class OptionsPane extends VBox {
    private Button startButton;
    private Button clearButton;
    private Board board;
    private MouseGestures mouseGestures;
    private boolean ready = false;
    private ListView listView;
    private AlgorithmEnum selectedAlgorithm = AlgorithmEnum.BFS;

    public OptionsPane(Board board, MouseGestures mouseGestures) {
        this.board = board;
        this.mouseGestures = mouseGestures;
        this.startButton = new Button("Save");
        this.startButton.setOnAction(onStartSaveClickEvent);

        this.clearButton = new Button("Clear");
        clearButton.setOnAction(onClearClickEvent);

        this.listView = new ListView<>();
        listView.getItems().addAll("BFS", "Dijkstra");

        listView.getSelectionModel().getSelectedItem();

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue){
                    case "BFS": selectedAlgorithm = AlgorithmEnum.BFS; break;
                    case "Dijkstra": selectedAlgorithm = AlgorithmEnum.DIJKSTRA; break;
                }
            }
        });



        this.getChildren().addAll(this.startButton, clearButton, listView);

        this.setStyle("-fx-padding: 10; -fx-alignment: top-center");
        this.setSpacing(10);
    }

    EventHandler<ActionEvent> onStartSaveClickEvent = event -> {
        if (!ready){
            if (this.mouseGestures.endIsPresent && this.mouseGestures.startIsPresent){
                this.startButton.setText("Start!");
                ready = true;
                this.mouseGestures.setCanModify(false);
                this.listView.setVisible(false);
            }
        } else {
            this.clearButton.setVisible(false);
            this.startButton.setVisible(false);

            Algorithm algorithm;
            switch (this.selectedAlgorithm){
                case BFS: algorithm = new BFS(this.board.getGraph()); break;
                case DIJKSTRA: algorithm = new Dijkstra(this.board.getGraph()); break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.selectedAlgorithm);
            }
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
        this.listView.setVisible(true);
        this.board.resetGraph();
        this.mouseGestures.setCanModify(true);
        this.startButton.setVisible(true);
        this.startButton.setText("Save");
        this.ready = false;
        this.mouseGestures.setEndIsPresent(false);
        this.mouseGestures.setStartIsPresent(false);
    };
}
