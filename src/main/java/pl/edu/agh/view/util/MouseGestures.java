package pl.edu.agh.view.util;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import lombok.Setter;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.view.Cell;

@Setter
public class MouseGestures {
    public boolean startIsPresent = false;
    public boolean endIsPresent = false;
    public boolean canModify = true;

    public void makePaintable(Node node){
        node.setOnMousePressed(onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        Cell cell = (Cell) event.getSource();
        if (this.canModify){
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    if (!startIsPresent){
                        cell.setStart();
                        startIsPresent = true;
                    } else if (!endIsPresent){
                        cell.setEnd();
                        endIsPresent = true;
                    }

                } else {
                    if (cell.getVertex().getState() == State.ACTIVE){
                        cell.setInactive();
                    }
                }
            } else {
                if (cell.getVertex().getState() == State.START){
                    startIsPresent = false;
                } else if (cell.getVertex().getState() == State.END){
                    endIsPresent = false;
                }
                cell.setActive();
            }
        }
    };
}
