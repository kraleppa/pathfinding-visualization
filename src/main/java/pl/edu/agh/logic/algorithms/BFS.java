package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vertex;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS extends Algorithm{
    private final Graph graph;
    private final Queue<Vertex> queue = new LinkedList<>();

    public BFS(Graph graph) {
        super(graph);
        this.graph = graph;
        queue.add(start);
    }

    public void startBFS(){
        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();

            for (Vertex v : graph.getVerticesMap().get(vertex)) {
                if (v.getState() == State.ACTIVE){
                    queue.add(v);
                    v.setState(State.VISITED);
                }



                if (v.getState() == State.END){
                    return;
                }
            }
        }
    }
}
