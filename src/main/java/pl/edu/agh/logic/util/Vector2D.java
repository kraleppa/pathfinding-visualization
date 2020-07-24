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

    public double distance(Vector2D other){
        return (Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2)));
    }
}
