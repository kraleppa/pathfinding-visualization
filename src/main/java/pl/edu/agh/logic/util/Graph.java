package pl.edu.agh.logic.util;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Graph {
    private final Map<Vertex, ArrayList<Vertex>> verticesMap = new HashMap<>();

    public void addVertex(Vector2D position){
        verticesMap.putIfAbsent(new Vertex(position), new ArrayList<>());
    }

    public void removeVertex(Vector2D position){
        Vertex mockVertex = new Vertex(position);
        verticesMap.values().forEach(e -> e.remove(mockVertex));
        verticesMap.remove(mockVertex);
    }

    private Optional<Vertex> getVertex(Vector2D position){
        return this.verticesMap.keySet().stream().filter((vertex -> vertex.getPosition().equals(position))).findFirst();
    }

    public void addEdge(Vector2D position1, Vector2D position2){
        verticesMap.get(getVertex(position1).get()).add(getVertex(position2).get());
    }
}
