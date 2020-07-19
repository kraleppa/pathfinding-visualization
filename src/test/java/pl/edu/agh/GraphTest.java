package pl.edu.agh;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vector2D;
import pl.edu.agh.logic.util.Vertex;

public class GraphTest {
    @Test
    public void addVertexTest(){
        //given
        Graph graph = new Graph();
        Vector2D position = new Vector2D(3, 3);

        //when
        graph.addVertex(position);

        //then
        assertEquals(1, graph.getVerticesMap().size());
    }

    @Test
    public void removeVertexTest(){
        //given
        Graph graph = new Graph();
        Vector2D position = new Vector2D(3, 3);

        //when
        graph.addVertex(position);
        graph.removeVertex(position);

        //then
        assertEquals(0, graph.getVerticesMap().size());
    }

    @Test
    public void addEdgeTest(){
        //given
        Graph graph = new Graph();
        Vector2D position1 = new Vector2D(3, 3);
        Vector2D position2 = new Vector2D(3, 4);

        //when
        graph.addVertex(position1);
        graph.addVertex(position2);

        graph.addEdge(position1, position2);

        //then
        assertEquals(1, graph.getVerticesMap().get(new Vertex(position1)).size());
        assertEquals(0, graph.getVerticesMap().get(new Vertex(position2)).size());
    }
}
