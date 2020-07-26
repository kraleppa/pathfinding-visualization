package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra extends Algorithm{
    protected Set<Vertex> unvisited = new HashSet<>();

    public Vertex getSmallestDistance(){
        return this.unvisited.stream()
                .min(Comparator.comparingDouble(Vertex::getDistance)).get();
    }

    public Dijkstra(Graph graph) {
        super(graph);
        graph.getVerticesMap().keySet().forEach(vertex -> {
                    if (vertex.equals(start)){
                        vertex.setDistance(0.0);
                    } else {
                        vertex.setDistance(Double.MAX_VALUE);
                    }
                });
        unvisited.addAll(graph.getVerticesMap().keySet());
    }

    public void relax(Vertex v1, Vertex v2){
        double weight = v1.getPosition().distance(v2.getPosition());
        if (v2.getDistance() > v1.getDistance() + weight){
            v2.setDistance(v1.getDistance() + weight);
            v2.setParent(v1);
        }
    }

    @Override
    public void startAlgorithm() {
        while (this.unvisited.size() != 0){
            Vertex currentVertex = getSmallestDistance();
            unvisited.remove(currentVertex);
            if (currentVertex.getState().equals(pl.edu.agh.logic.util.State.END)){
                return;
            }
            if (currentVertex.getState().equals(pl.edu.agh.logic.util.State.ACTIVE) ||
                    currentVertex.getState().equals(pl.edu.agh.logic.util.State.START)){
                if (!currentVertex.equals(start)){
                    currentVertex.setState(pl.edu.agh.logic.util.State.VISITED);
                }
                for (Vertex vertex : graph.getVerticesMap().get(currentVertex)){
                    relax(currentVertex, vertex);
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
