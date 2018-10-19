package heap;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class SorterTest {

    @Test
    public void testSortOddNumberOfElems() {
        //given
        double[] list = {123.0, 12.23, 12.3};
        Sorter sorter = new Sorter();
        
        //when
        list = sorter.sort(list);
        double[] expected = {12.23, 12.3, 123.0};
        
        //then
        assertTrue(Arrays.equals(list, expected));
    }
    
    @Test
    public void testSortEvenNumberOfElems() {
        //given
        double[] list = {123.0, 12.23, 12.3, 53245.6};
        
        //when
        Sorter sorter = new Sorter();
        list = sorter.sort(list);
        double[] expected = {12.23, 12.3, 123.0, 53245.6};
        
        //then
        assertTrue(Arrays.equals(list, expected));
    }

    @Test
    public void testSortOneElem() {
        //given
        double[] list = {123543268.6};
        Sorter sorter = new Sorter();
        
        //when
        list = sorter.sort(list);
        
        //then
        assertEquals(list[0], 123543268.6, 0.0001);
    }
    
    @Test
    public void testSortRepsInsideList() {
        //given
        double[] list = {123543268.6, 12, 45.6, 34, 123543268.6};
        Sorter sorter = new Sorter();
        
        //when
        list = sorter.sort(list);
        
        //then
        assertEquals(list[3], 123543268.6, 0.0001);
        assertEquals(list[4], 123543268.6, 0.0001);
    }  
    
    @Test
    public void testSortEmptyListNotChanged() {
        //given
        double[] list = {};
        Sorter sorter = new Sorter();
        
        //when
        list = sorter.sort(list);
        
        //then
        assertEquals(0, list.length);
    } 
}
