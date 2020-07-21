package pl.edu.agh.logic.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.edu.agh.view.Cell;

import java.util.Objects;
import java.util.Observable;

@Getter
public class Vertex {
    private final Vector2D position;
    private Cell cell;
    private State state;

    public void setState(State state) {
        this.state = state;
        this.cell.updateVisited();
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Vertex(Vector2D position) {
        this.position = position;
        this.state = State.ACTIVE;
    }

    @Override
    public String toString() {
        return position.toString() + "\n state: " + state.toString();
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
