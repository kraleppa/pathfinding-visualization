package pl.edu.agh.logic.board;

import lombok.Getter;
import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.State;

@Getter
public class Board {
    private final Graph graph;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.graph = new Graph();
    }

    public Board() {
        this(50);
    }

    public void clearGraph(){
        graph.getVerticesMap().keySet().forEach(vertex -> vertex.setState(State.ACTIVE));
    }

    public void resetGraph(){
        graph.getVerticesMap().keySet().forEach(vertex -> {
            if (vertex.getState() != State.INACTIVE){
                vertex.setState(State.ACTIVE);
            }
        });
    }
}
