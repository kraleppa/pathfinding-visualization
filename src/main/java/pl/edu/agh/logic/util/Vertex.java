package pl.edu.agh.logic.util;

import lombok.Getter;
import pl.edu.agh.view.Cell;
import java.util.Objects;

@Getter
public class Vertex {
    private final Vector2D position;
    private Cell cell;
    private State state;
    private Vertex parent;

    public void setState(State state) {
        this.state = state;
        if (state == State.VISITED){
            this.cell.updateVisited();
        }

        if (state == State.PATH){
            this.cell.updatePath();
        }

        if (state == State.ACTIVE){
            this.cell.updateActive();
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex(Vector2D position) {
        this.position = position;
        this.state = State.ACTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return position.equals(vertex.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }


}
