package pl.edu.agh.logic.board;

import lombok.Getter;
import pl.edu.agh.logic.util.Graph;

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

//    public void constructGraph(){
//        BoardBuilder boardBuilder = new StandardBoardBuilder(this);
//        boardBuilder.constructArrayGraph();
//    }


}
