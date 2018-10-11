package heapsort;

import org.junit.Test;
import static org.junit.Assert.*;

public class HeapSortTest {
    
    @Test
    public void testSortShortTable() {
        HeapSort hs = new HeapSort();
        double tab [] = {1, 2, 4, 3, 7, 5};
        tab = hs.sort(tab);
        assertEquals(4, tab[3], 0.001);
        assertEquals(7, tab[5], 0.001);
    }
    
    @Test
    public void testSortLongTable() {
        HeapSort hs = new HeapSort();
        double tab [] = {10, 7, 8.5, 3, 32, 1, 11, 111, 67.99, 71};
        tab = hs.sort(tab);
        assertEquals(1, tab[0], 0.001);
        assertEquals(111, tab[9], 0.001);
        assertEquals(67.99, tab[7], 0.001);
    }
    
    @Test
    public void testSortEmptyTable() {
        HeapSort hs = new HeapSort();
        double tab [] = {};
        tab = hs.sort(tab);
        assertEquals(0, tab.length);
    }
    
    @Test
    public void testSortOneElemTable() {
        HeapSort hs = new HeapSort();
        double tab [] = {1};
        tab = hs.sort(tab);
        assertEquals(1, tab[0], 0.001);
    }
    
    @Test
    public void testTableWithRepeats() {
        HeapSort hs = new HeapSort();
        double tab [] = {1, 5, 5, 3, 5, 1, 5, 7};
        tab = hs.sort(tab);
        assertEquals(1, tab[1], 0.001);
        assertEquals(5, tab[5], 0.001);
        assertEquals(7, tab[7], 0.001);
    }
    
    @Test
    public void testSortNullTable() {
        HeapSort hs = new HeapSort();
        double tab [] = null;
        tab = hs.sort(tab);
        assertNull(tab);
    }
}
