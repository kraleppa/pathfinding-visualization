package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vertex;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra extends Algorithm{
    private Set<Vertex> unVisited = new HashSet<>();

    public Vertex getSmallestDistance(){
        return this.unVisited.stream()
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
        unVisited.addAll(graph.getVerticesMap().keySet());
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
        while (this.unVisited.size() != 0){
            Vertex currentVertex = getSmallestDistance();
            unVisited.remove(currentVertex);
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
