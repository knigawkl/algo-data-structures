package heap;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void testSizeIncreasingAfterPut() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        heap.put(12.3);
        
        //then
        assertEquals(heap.getSize(), 4);   
    }

    @Test
    public void testSizeDecreasingAfterPop() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        heap.pop();
        
        //then
        assertEquals(heap.getSize(), 2);
    }

    @Test
    public void testGetSize() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //then
        assertEquals(heap.getSize(), 3);
    }

    @Test
    public void testToString() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        
        //then
        Heap<Double> heap = new Heap<>(list);
        assertEquals(heap.toString(), "[22.3, 2.3, 12.3]");
    }
    
    @Test
    public void testPutFront() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        heap.put(83.4);
        ArrayList<Double> array = heap.getArrayList();
        
        //then
        assertEquals(array.get(0), (Double) 83.4);
    }
    
    @Test
    public void testPutMiddle() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        heap.put(20.6);
        ArrayList<Double> array = heap.getArrayList();
        
        //then
        assertEquals(array.get(1), (Double) 20.6);
    }
    
    @Test
    public void testPutBack() {
        //given
        Double[] list = {2.3, 22.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        heap.put(0.12345678);
        ArrayList<Double> array = heap.getArrayList();
        
        //then
        assertEquals(array.get(3), (Double) 0.12345678);
    }
    
    @Test
    public void testPop() {
        //given
        Double[] list = {22.3, 2.3, 12.3};
        Heap<Double> heap = new Heap<>(list);
        
        //when
        Double popped = heap.pop();
        
        //then
        assertEquals(popped, (Double) 22.3);
    }
    
}
