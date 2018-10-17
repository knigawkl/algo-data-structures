package custommap;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomMapTest {

    @Test
    public void testSetValueInteger() {
        CustomMap<Integer, Integer> drzewko = new CustomMap<Integer, Integer>();
        drzewko.setValue(12, 13);
        int result = (int) drzewko.getValue(12);
        assertEquals(result, 13);
    }

    @Test
    public void testGetValue() {
    }

    @Test
    public void testMain() {
    }
    
}
