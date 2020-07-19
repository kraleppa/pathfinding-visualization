package pl.edu.agh.logic.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Vertex {
    private final Vector2D position;

    @Override
    public String toString() {
        return position.toString();
    }
}
