package mymap;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void testGetValueIntFromConstructor() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(2, 3);

        //when
        Integer result = tested.getValue(2);

        //then
        assertEquals(3, result, 0);
    }

    @Test
    public void testGetValueStringFromConstructor() {
        //given
        MyMap<String, String> tested = new MyMap<>("Robert", "Lewandowski");

        //when
        String result = tested.getValue("Robert");

        //then
        assertEquals("Lewandowski", result);
    }

    @Test
    public void testGetValueIntFromPutting() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(88, 98);

        //when
        tested.setValue(25, 30);
        Integer result = tested.getValue(25);

        //then
        assertEquals(30, result, 0);
    }

    @Test
    public void testGetValueStringFromPutting() {
        //given
        MyMap<String, String> tested = new MyMap<>("Robert", "Lewandowski");

        //when
        String result = tested.getValue("Robert");

        //then
        assertEquals("Lewandowski", result);
    }

    @Test
    public void testGetValueIntegerNoSuchKey() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(6, 6);

        //when
        Integer dua = tested.getValue(8);

        //then
        assertEquals(null, dua);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetValueNullKey() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(2, 3);

        //when
        tested.getValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNullKey() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(2, 3);

        //when
        tested.setValue(null, 123);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNullValue() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(2, 3);

        //when
        tested.setValue(123, null);
    }

    @Test
    public void testSetValueInteger() {
        //given
        MyMap<Integer, Integer> tested = new MyMap<>(2, 3);
        
        //when
        tested.setValue(3, 4);
        Integer result = tested.getValue(3);
        
        //then
        assertEquals(4, result, 0);
    }
    
    @Test
    public void testSetValueIntegerAlreadySuchKeyInMap() {

    }

}
