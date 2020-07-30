package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vertex;

import java.awt.geom.IllegalPathStateException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomWalk extends Algorithm{
    private Vertex currentVertex;

    public Vertex getUnvisitedNeighbour(Vertex vertex){
        List<Vertex> list = graph.getVerticesMap().get(vertex).stream().filter(
                v -> v.getState() == pl.edu.agh.logic.util.State.ACTIVE ||
                        v.getState() == pl.edu.agh.logic.util.State.END
                ).collect(Collectors.toList());
        if (list.size() == 0){
            return null;
        }
        Random rand = new Random();
        Vertex vertex1 = list.get(rand.nextInt(list.size()));
        vertex1.setParent(vertex);
        return vertex1;
    }

    public RandomWalk(Graph graph) {
        super(graph);
        currentVertex = start;
    }

    @Override
    public void startAlgorithm() {
        while (true){
            currentVertex = getUnvisitedNeighbour(currentVertex);
            if (currentVertex == null){
                throw new IllegalPathStateException("Path not found!");
            }
            if (currentVertex.getState() == pl.edu.agh.logic.util.State.END){
                return;
            }
            currentVertex.setState(pl.edu.agh.logic.util.State.VISITED);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
