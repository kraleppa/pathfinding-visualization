package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;

import java.awt.geom.IllegalPathStateException;
import java.util.Stack;

public class DFS extends Algorithm{
    private final Stack<Vertex> stack = new Stack<>();

    public DFS(Graph graph) {
        super(graph);
        stack.add(start);
    }

    @Override
    public void startAlgorithm() {
        while (!stack.isEmpty()){
            Vertex vertex = stack.pop();

            for (Vertex v : graph.getVerticesMap().get(vertex)) {
                if (v.getState() == pl.edu.agh.logic.util.State.ACTIVE){
                    stack.push(v);
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
        throw new IllegalPathStateException("Path not found!");
    }
}
