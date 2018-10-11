package heap;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void testSizeIncreasingAfterPut() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        heap.put(12.3);
        assertEquals(heap.getSize(), 4);   
    }

    @Test
    public void testSizeDecreasingAfterPop() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        heap.pop();
        assertEquals(heap.getSize(), 2);
    }

    @Test
    public void testGetSize() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        assertEquals(heap.getSize(), 3);
    }

    @Test
    public void testToString() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        assertEquals(heap.toString(), "[22.3, 2.3, 12.3]");
    }
    
    @Test
    public void testPutFront() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        heap.put(83.4);
        ArrayList<Double> array = heap.getArrayList();
        assertEquals(array.get(0), (Double) 83.4);
    }
    
    @Test
    public void testPutMiddle() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        heap.put(20.6);
        ArrayList<Double> array = heap.getArrayList();
        assertEquals(array.get(1), (Double) 20.6);
    }
    
    @Test
    public void testPutBack() {
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        heap.put(0.12345678);
        ArrayList<Double> array = heap.getArrayList();
        assertEquals(array.get(3), (Double) 0.12345678);
    }
    
    @Test
    public void testPop() {
        Double[] list = {22.3, 2.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        Double popped = heap.pop();
        assertEquals(popped, (Double) 22.3);
    }
    
}
