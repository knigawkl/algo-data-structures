package heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private final ArrayList<T> array;

    public Heap(T[] objects) {
        array = new ArrayList<>();
        for (T object : objects) {
            put(object);
        }
    }

    //puts an item onto the heap as the last leaf, then rebuilds the heap
    @Override
    public void put(T item) {
        array.add(item);

        int currentIndex = array.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (array.get(currentIndex).compareTo(array.get(parentIndex)) > 0) {
                T temp = array.get(currentIndex);
                array.set(currentIndex, array.get(parentIndex));
                array.set(parentIndex, temp);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    //pops the root element from the heap
    @Override
    public T pop() {
        if (array.isEmpty()) {
            return null;
        }

        T removed = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.remove(array.size() - 1);

        int currentIndex = 0;
        while (currentIndex < array.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= array.size()) {
                break;
            }

            int maxIndex = leftChildIndex;

            if (rightChildIndex < array.size() && array.get(maxIndex).compareTo(array.get(rightChildIndex)) < 0) {
                maxIndex = rightChildIndex;
            }
            if (array.get(currentIndex).compareTo(array.get(maxIndex)) < 0) {
                T temp = array.get(maxIndex);
                array.set(maxIndex, array.get(currentIndex));
                array.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }

        return removed;

    }

    public int getSize() {
        return array.size();
    }

    @Override
    public String toString() {
        return this.array.toString();
    }

    public ArrayList<T> getArrayList() {
        return array;
    }
    
}
