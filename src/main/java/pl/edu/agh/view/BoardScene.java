package pl.edu.agh.view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.board.builder.BoardBuilder;
import pl.edu.agh.logic.board.builder.NineTilesBoardBuilder;
import pl.edu.agh.logic.board.builder.StandardBoardBuilder;

public class BoardScene extends Scene {
    public BoardScene(Pane root, double width, double height) {
        super(root, Color.WHITE);
        Board board = new Board();
        Grid grid = new Grid(board.getBoardSize(), board.getBoardSize(), width - 50, height - 50);

        BoardBuilder boardBuilder = new NineTilesBoardBuilder(board);
        boardBuilder.constructGraph();

        MouseGestures mouseGestures = new MouseGestures();

        board.getGraph().getVerticesMap().keySet().forEach(vertex -> {
            Cell cell = new Cell(vertex);
            mouseGestures.makePaintable(cell);
            grid.add(cell);
        });

        root.getChildren().addAll(new OptionsPane(board, mouseGestures), grid);
    }
}
