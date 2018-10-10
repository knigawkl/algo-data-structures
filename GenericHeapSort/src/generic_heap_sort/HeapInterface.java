/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic_heap_sort;

/**
 *
 * @author Hugo
 */
public interface HeapInterface<T extends Comparable<T>> {
    public void put(T item); // dodaje element do kopca
    public T pop(); // pobiera element "największy" wg naturalnej kolejności
    
}
