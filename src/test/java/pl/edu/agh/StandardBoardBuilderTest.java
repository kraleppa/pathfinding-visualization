package pl.edu.agh;

import org.junit.Test;
import pl.edu.agh.logic.board.Board;
import pl.edu.agh.logic.board.builder.BoardBuilder;
import pl.edu.agh.logic.board.builder.StandardBoardBuilder;
import pl.edu.agh.logic.util.Vector2D;
import pl.edu.agh.logic.util.Vertex;

import static org.junit.jupiter.api.Assertions.*;

public class StandardBoardBuilderTest {
    @Test
    public void constructGraphTestCase1(){
        //given
        Board board = new Board(3);
        BoardBuilder boardBuilder = new StandardBoardBuilder(board);

        //when
        boardBuilder.constructGraph();

        //then
        Vertex mockVertex = new Vertex(new Vector2D(0, 0));
        assertEquals(2, board.getGraph().getVerticesMap().get(mockVertex).size());
    }

    @Test
    public void constructGraphTestCase2(){
        //given
        Board board = new Board(3);
        BoardBuilder boardBuilder = new StandardBoardBuilder(board);

        //when
        boardBuilder.constructGraph();

        //then
        Vertex mockVertex = new Vertex(new Vector2D(1, 1));
        assertEquals(4, board.getGraph().getVerticesMap().get(mockVertex).size());
    }

    @Test
    public void constructGraphTestCase3(){
        //given
        Board board = new Board(3);
        BoardBuilder boardBuilder = new StandardBoardBuilder(board);

        //when
        boardBuilder.constructGraph();

        //then
        Vertex mockVertex = new Vertex(new Vector2D(2, 2));
        assertEquals(2, board.getGraph().getVerticesMap().get(mockVertex).size());
    }
}
