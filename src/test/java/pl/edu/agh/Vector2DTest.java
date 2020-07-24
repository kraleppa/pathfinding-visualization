package pl.edu.agh;

import org.junit.Test;
import pl.edu.agh.logic.util.Vector2D;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {
    @Test
    public void distanceTest1(){
        //given
        Vector2D v1 = new Vector2D(0,0);
        Vector2D v2 = new Vector2D(0, 1);

        //when
        double distance = v1.distance(v2);

        //then
        assertEquals(distance, 1);
    }

    @Test
    public void distanceTest2(){
        //given
        Vector2D v1 = new Vector2D(0,0);
        Vector2D v2 = new Vector2D(1, 1);

        //when
        double distance = v1.distance(v2);

        //then
        assertEquals(0, Double.compare(distance, Math.sqrt(2)));
    }
}
