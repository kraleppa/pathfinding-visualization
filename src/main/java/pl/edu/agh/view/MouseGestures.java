package pl.edu.agh.view;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import pl.edu.agh.logic.util.State;


public class MouseGestures {
    //TO DO!
    private int doubleClickCount = 0;

    public void makePaintable(Node node){
        node.setOnMousePressed(onMousePressedEventHandler);
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        Cell cell = (Cell) event.getSource();

        if(event.getButton().equals(MouseButton.PRIMARY)){
            if(event.getClickCount() == 2){

                //TO DO! //////////////////////////////

                if (doubleClickCount == 0){
                    cell.setStart();
                }
                if (doubleClickCount == 1){
                    cell.setEnd();
                }
                doubleClickCount++;

                ////////////////////////////////////////
            } else {
                cell.setInactive();
            }
        } else {
            cell.setActive();
        }


    };
}
