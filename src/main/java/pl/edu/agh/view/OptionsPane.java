package pl.edu.agh.view;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import pl.edu.agh.logic.algorithms.AStar;
import pl.edu.agh.logic.algorithms.Algorithm;
import pl.edu.agh.logic.algorithms.BFS;
import pl.edu.agh.logic.algorithms.Dijkstra;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.view.util.AlgorithmEnum;
import pl.edu.agh.view.util.MouseGestures;

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
        listView.getItems().addAll("BFS", "Dijkstra", "A*");
        this.listView.setPrefHeight(80);

        listView.getSelectionModel().getSelectedItem();

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue){
                    case "BFS": selectedAlgorithm = AlgorithmEnum.BFS; break;
                    case "Dijkstra": selectedAlgorithm = AlgorithmEnum.DIJKSTRA; break;
                    case "A*": selectedAlgorithm = AlgorithmEnum.ASTAR; break;
                }
            }
        });



        this.getChildren().addAll(this.startButton, clearButton, listView);

        this.setStyle("-fx-padding: 10; -fx-alignment: top-center");
        this.setSpacing(10);
    }

    EventHandler<ActionEvent> resetGraph = event -> {
        this.board.resetGraph();
        this.refresh();
    };

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
                case ASTAR: algorithm = new AStar(this.board.getGraph()); break;
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
                    Platform.runLater(() -> {
                        this.clearButton.setVisible(true);
                        this.startButton.setText("Reset");
                        this.startButton.setOnAction(resetGraph);
                        this.startButton.setVisible(true);
                    });

                }
            });

            waitForEndThread.start();

        }
    };

    EventHandler<ActionEvent> onClearClickEvent = event -> {
        this.board.clearGraph();
        this.refresh();
    };

    public void refresh(){
        this.listView.setVisible(true);
        this.mouseGestures.setCanModify(true);
        this.startButton.setText("Save");
        this.startButton.setOnAction(onStartSaveClickEvent);
        this.ready = false;
        this.mouseGestures.setEndIsPresent(false);
        this.mouseGestures.setStartIsPresent(false);
    }


}
