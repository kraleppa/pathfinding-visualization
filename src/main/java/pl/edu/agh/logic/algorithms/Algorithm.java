package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;

import java.awt.geom.IllegalPathStateException;

public abstract class Algorithm extends Thread{
    protected final Graph graph;
    protected Vertex start;
    protected Vertex end;

    public Algorithm(Graph graph){
        this.graph = graph;
        for (Vertex vertex : graph.getVerticesMap().keySet()){
            if (vertex.getState() == pl.edu.agh.logic.util.State.START){
                this.start = vertex;
                this.start.setParent(null);
            } else if (vertex.getState() == pl.edu.agh.logic.util.State.END){
                this.end = vertex;
            }
        }
        if (this.end == null || this.start == null){
            throw new IllegalStateException("Start or End vertex does not exist");
        }
    }

    public void backtrace(){
        Vertex currentVertex = this.end.getParent();
        while (currentVertex.getParent() != null){
            currentVertex.setState(pl.edu.agh.logic.util.State.PATH);
            currentVertex = currentVertex.getParent();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            startAlgorithm();
        } catch (IllegalPathStateException e){
            return;
        }
        backtrace();
    }

    public abstract void startAlgorithm();
}
