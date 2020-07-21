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
            } else if (vertex.getState() == pl.edu.agh.logic.util.State.END){
                this.stop = vertex;
            }
        }
        if (this.stop == null || this.start == null){
            System.exit(69);             //EXCEPTIONS!!!!!
        }
    }

    @Override
    public void run() {
        super.run();
        startAlgorithm();
    }

    public abstract void startAlgorithm();


}
