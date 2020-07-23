package pl.edu.agh.logic.board.builder;

import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.util.Vector2D;

public class NineTilesBoardBuilder extends StandardBoardBuilder{

    public NineTilesBoardBuilder(Board board) {
        super(board);
    }

    @Override
    public void constructGraph() {
        super.constructGraph();
        for (int x = 0; x < currentBoard.getBoardSize(); x++){
            for (int y = 0; y < currentBoard.getBoardSize(); y++){
                Vector2D position1 = new Vector2D(x, y);
                if (x + 1 < currentBoard.getBoardSize() && y + 1 < currentBoard.getBoardSize()){
                    currentBoard.getGraph().addEdge(position1, new Vector2D(x + 1, y + 1));
                }

                if (x + 1 < currentBoard.getBoardSize() && y - 1 >= 0){
                    currentBoard.getGraph().addEdge(position1, new Vector2D(x + 1, y - 1));
                }

                if (x - 1 >= 0 && y - 1 >= 0){
                    currentBoard.getGraph().addEdge(position1, new Vector2D(x - 1, y - 1));
                }

                if (x - 1 >= 0 && y + 1 < currentBoard.getBoardSize()){
                    currentBoard.getGraph().addEdge(position1, new Vector2D(x - 1, y + 1));
                }
            }
        }
    }
}
