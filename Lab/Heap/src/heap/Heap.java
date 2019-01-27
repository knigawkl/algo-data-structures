package heap;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private final ArrayList<T> elems;

    public Heap(T[] objects) {
        elems = new ArrayList<>();
        for (T object : objects) {
            put(object);
        }
    }

    @Override
    public void put(T item) {
        elems.add(item);

        int currentIndex = elems.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (elems.get(currentIndex).compareTo(elems.get(parentIndex)) > 0) {
                T temp = elems.get(currentIndex);
                elems.set(currentIndex, elems.get(parentIndex));
                elems.set(parentIndex, temp);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    @Override
    public T pop() {
        if (elems.isEmpty()) {
            return null;
        }

        T removed = elems.get(0);
        elems.set(0, elems.get(elems.size() - 1));
        elems.remove(elems.size() - 1);

        int currentIndex = 0;
        while (currentIndex < elems.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= elems.size()) {
                break;
            }

            int maxIndex = leftChildIndex;

            if (rightChildIndex < elems.size() && elems.get(maxIndex).compareTo(elems.get(rightChildIndex)) < 0) {
                maxIndex = rightChildIndex;
            }
            if (elems.get(currentIndex).compareTo(elems.get(maxIndex)) < 0) {
                T temp = elems.get(maxIndex);
                elems.set(maxIndex, elems.get(currentIndex));
                elems.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }

        return removed;

    }

    public int getSize() {
        return elems.size();
    }

    @Override
    public String toString() {
        return this.elems.toString();
    }

    public ArrayList<T> getArrayList() {
        return elems;
    }
    
}
