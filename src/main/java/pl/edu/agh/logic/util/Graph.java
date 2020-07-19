package pl.edu.agh.logic.util;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Graph {
    private final Map<Vertex, ArrayList<Object>> verticesMap = new HashMap<>();

    public void addVertex(Vector2D position){
        verticesMap.putIfAbsent(new Vertex(position), new ArrayList<>());
    }

    public void removeVertex(Vector2D position){
        Vertex mockVertex = new Vertex(position);
        verticesMap.values().forEach(e -> e.remove(mockVertex));
        verticesMap.remove(mockVertex);
    }

    public void addEdge(Vector2D position1, Vector2D position2){
        Vertex mockVertex1 = new Vertex(position1);
        Vertex mockVertex2 = new Vertex(position2);

        verticesMap.get(mockVertex1).add(mockVertex2);
        verticesMap.get(mockVertex2).add(mockVertex1);
    }
}
