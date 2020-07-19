package pl.edu.agh.logic.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Vector2D {
    private int x;
    private int y;

    @Override
    public String toString() {
        return ("(" + x + " ," + y + ")");
    }
}
