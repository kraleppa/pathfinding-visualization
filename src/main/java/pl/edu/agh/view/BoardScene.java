package pl.edu.agh.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.board.builder.BoardBuilder;
import pl.edu.agh.logic.board.builder.StandardBoardBuilder;
import pl.edu.agh.logic.util.Vector2D;

import java.util.HashMap;
import javafx.scene.shape.Rectangle;
import java.util.Map;

public class BoardScene extends Scene {
    private final Board board;
    private final Map<Vector2D, Rectangle> cellMap = new HashMap<>();

    public BoardScene(Pane root, double width, double height) {
        super(root, width, height, Color.WHITE);

        this.board = new Board(10);
        BoardBuilder boardBuilder = new StandardBoardBuilder(board);
        boardBuilder.constructGraph();

        Group group = new Group();

        this.board.getGraph()
                .getVerticesMap()
                .keySet()
                .forEach((vertex -> {
                    Vector2D vector2D = vertex.getPosition();
                    Rectangle rectangle = this.createRectangle(vector2D);
                    cellMap.put(vector2D, rectangle);
                    group.getChildren().add(rectangle);
                }));
        root.getChildren().add(group);
    }

    private Rectangle createRectangle(Vector2D position) {
        Rectangle rectangle = new Rectangle(10, 10);
        rectangle.setX(position.getX() * 10);
        rectangle.setY(position.getY() * 10);
        rectangle.setStyle("-fx-fill: red; -fx-stroke: black; -fx-stroke-width: 5;");
        return rectangle;
    }
}
