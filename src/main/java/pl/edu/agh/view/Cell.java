package pl.edu.agh.view;

import javafx.scene.layout.StackPane;
import lombok.Getter;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vertex;

@Getter
public class Cell extends StackPane {
    private Vertex vertex;

    public Cell(Vertex vertex) {
        super();
        this.vertex = vertex;

        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.setOpacity(0.9);
    }

    public void setInactive(){
        this.getStyleClass().clear();
        this.setStyle("-fx-background-color: black");
        this.vertex.setState(State.INACTIVE);
    }

    public void setStart(){
        this.getStyleClass().clear();
        this.setStyle("-fx-background-color: yellow");
        this.vertex.setState(State.START);
    }

    public void setEnd(){
        this.getStyleClass().clear();
        this.setStyle("-fx-background-color: greenyellow");
        this.vertex.setState(State.END);
    }

    public void setActive(){
        this.getStyleClass().clear();
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.vertex.setState(State.ACTIVE);
    }


}
