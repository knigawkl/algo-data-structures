package genericheapsort;

import java.util.Arrays;

public class GenericHeap<T extends Comparable<T>> implements HeapInteface<T> {

    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size; //number of elems in the heap

    public GenericHeap() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0; 
    }

    @Override
    public void put(T item) {
        if (size >= array.length) {
            array = this.resize();
        }
        int index = size;
        size++;
        array[index] = item;

        bubbleUp();
    }

    @Override
    public T pop() {
        T result = peek();

        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;

        bubbleDown();

        return result;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return array[0];
    }

    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void bubbleDown() {
        int index = 0;

        while (index * 2 + 1 <= size) {

            int biggerChild = index * 2 + 1;

            if ((index * 2 + 2 <= size) && array[index * 2 + 2].compareTo(array[index * 2 + 1]) > 0) {
                biggerChild = index * 2 + 2;
            }

            if (array[biggerChild].compareTo(array[index]) > 0) {
                swap(index, biggerChild);
            } else {
                break;
            }
            index = biggerChild;
        }
    }

    protected void bubbleUp() {
        int index = this.size;

        while (index > 0 && array[index].compareTo(array[(index - 1) / 2]) > 0 ) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    
    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
