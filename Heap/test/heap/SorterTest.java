package heap;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class SorterTest {

    @Test
    public void testSortOddNumberOfElems() {
        double[] list = {123.0, 12.23, 12.3};
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        double[] expected = {12.23, 12.3, 123.0};
        assertTrue(Arrays.equals(list, expected));
    }
    
    @Test
    public void testSortEvenNumberOfElems() {
        double[] list = {123.0, 12.23, 12.3, 53245.6};
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        double[] expected = {12.23, 12.3, 123.0, 53245.6};
        assertTrue(Arrays.equals(list, expected));
    }

    @Test
    public void testSortOneElem() {
        double[] list = {123543268.6};
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        assertEquals(list[0], 123543268.6, 0.0001);
    }
    
    @Test
    public void testSortRepsInsideList() {
        double[] list = {123543268.6, 12, 45.6, 34, 123543268.6};
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        assertEquals(list[3], 123543268.6, 0.0001);
        assertEquals(list[4], 123543268.6, 0.0001);
    }  
    
    @Test
    public void testSortEmptyListNotChanged() {
        double[] list = {};
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        assertEquals(0, list.length);
    } 
}
