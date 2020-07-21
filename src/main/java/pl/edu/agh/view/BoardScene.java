package pl.edu.agh.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.board.builder.BoardBuilder;
import pl.edu.agh.logic.board.builder.StandardBoardBuilder;

public class BoardScene extends Scene {

    private final Board board;
    private final Grid grid;
    private boolean editModeActive;
    private Button start;

    public BoardScene(StackPane root, double width, double height) {
        super(root, width, height, Color.WHITE);
        this.board = new Board();
        this.grid = new Grid(board.getBoardSize(), board.getBoardSize(), width, height);
        this.editModeActive = true;
        this.start = new Button("Start!");

        this.start.setOnAction(actionEvent -> {
            this.start.setText("KURWAAA");
        });

        BoardBuilder boardBuilder = new StandardBoardBuilder(board);
        boardBuilder.constructGraph();

        MouseGestures mg = new MouseGestures(editModeActive);

        this.board.getGraph().getVerticesMap().keySet().forEach(vertex -> {
            Cell cell = new Cell(vertex);
            mg.makePaintable(cell);
            grid.add(cell);

        });

        root.getChildren().addAll(grid, this.start);
    }
}
