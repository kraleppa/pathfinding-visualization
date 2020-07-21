package pl.edu.agh.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.board.builder.BoardBuilder;
import pl.edu.agh.logic.board.builder.StandardBoardBuilder;
import pl.edu.agh.logic.util.Vector2D;

import java.util.HashMap;


import java.util.Map;

public class BoardScene extends Scene {

    private final Board board;
    private final Grid grid;

    public BoardScene(StackPane root, double width, double height) {
        super(root, width, height, Color.WHITE);
        this.board = new Board();
        this.grid = new Grid(board.getBoardSize(), board.getBoardSize(), width, height);

        BoardBuilder boardBuilder = new StandardBoardBuilder(board);
        boardBuilder.constructGraph();

        MouseGestures mg = new MouseGestures();

        this.board.getGraph().getVerticesMap().keySet().forEach(vertex -> {
            Cell cell = new Cell(vertex);
            mg.makePaintable(cell);
            grid.add(cell);

        });
        root.getChildren().addAll(grid);
    }
}
