package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.Vertex;

public abstract class Algorithm extends Thread{
    protected Vertex start;
    protected Vertex stop;

    public Algorithm(Graph graph){
        for (Vertex vertex : graph.getVerticesMap().keySet()){
            if (vertex.getState() == pl.edu.agh.logic.util.State.START){
                this.start = vertex;
                this.start.setParent(null);
            } else if (vertex.getState() == pl.edu.agh.logic.util.State.END){
                this.stop = vertex;
            }
        }
        if (this.stop == null || this.start == null){
            //TODO  Exception here!!!
            System.exit(69);
        }
    }

    public void backtrace(){
        Vertex currentVertex = this.stop.getParent();
        while (currentVertex.getParent() != null){
            currentVertex.setState(pl.edu.agh.logic.util.State.PATH);
            currentVertex = currentVertex.getParent();
        }
    }

    @Override
    public void run() {
        super.run();
        startAlgorithm();
        backtrace();
    }

    public abstract void startAlgorithm();
}