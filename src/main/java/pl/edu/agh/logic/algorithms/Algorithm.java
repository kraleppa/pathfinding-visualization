package pl.edu.agh.logic.algorithms;

import pl.edu.agh.logic.util.Graph;
import pl.edu.agh.logic.util.State;
import pl.edu.agh.logic.util.Vertex;

public abstract class Algorithm {
    protected Vertex start;
    protected Vertex stop;

    public Algorithm(Graph graph){
        for (Vertex vertex : graph.getVerticesMap().keySet()){
            if (vertex.getState() == State.START){
                this.start = vertex;
            } else if (vertex.getState() == State.END){
                this.stop = vertex;
            }

            if (this.stop == null || this.start == null){
                System.exit(1);             //EXCEPTIONS!!!!!
            }
        }
    }
}
