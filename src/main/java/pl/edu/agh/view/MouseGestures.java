package pl.edu.agh.view;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


public class MouseGestures {
    public void makePaintable(Node node){
        node.setOnMousePressed(onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        Cell cell = (Cell) event.getSource();
        cell.paint();
    };
}
