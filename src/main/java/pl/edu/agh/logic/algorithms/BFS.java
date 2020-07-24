package pl.edu.agh.logic.algorithms;

import javafx.application.Platform;
import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Algorithm{
    private final Queue<Vertex> queue = new LinkedList<>();

    public BFS(Graph graph) {
        super(graph);
        queue.add(start);
    }

    @Override
    public void startAlgorithm() {
        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();

            for (Vertex v : graph.getVerticesMap().get(vertex)) {
                if (v.getState() == pl.edu.agh.logic.util.State.ACTIVE){
                    queue.add(v);
                    v.setState(pl.edu.agh.logic.util.State.VISITED);
                    v.setParent(vertex);
                }

                if (v.getState() == pl.edu.agh.logic.util.State.END){
                    v.setParent(vertex);
                    return;
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
