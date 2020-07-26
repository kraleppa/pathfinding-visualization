package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;

import java.util.Comparator;

public class AStar extends Dijkstra{
    public AStar(Graph graph) {
        super(graph);
    }

    @Override
    public Vertex getSmallestDistance() {
        return super.unvisited.stream()
                .min(Comparator.comparingDouble(
                        vertex -> vertex.getDistance() + vertex.getPosition().distance(stop.getPosition()))).get();
    }
}
