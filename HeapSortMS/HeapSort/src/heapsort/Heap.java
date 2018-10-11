package heapsort;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private final ArrayList<T> heapBody;

    public Heap(T[] data) {
        heapBody = new ArrayList <>();
        for (T data1 : data) {
            put(data1);
        }
    }

    @Override
    public T pop() {
        T temporary = heapBody.get(0);
        heapBody.set(0, heapBody.get(heapBody.size() - 1));
        heapBody.set(heapBody.size() - 1, temporary);
        heapBody.remove(heapBody.size() - 1);
        heapify(0);
        return temporary;
    }

    @Override
    public void put(T item) {
        heapBody.add(item);
        for (int i = heapBody.size() / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int getSize() {
        return heapBody.size();

    }

    private void heapify(int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heapBody.size() && heapBody.get(left).compareTo(heapBody.get(largest)) > 0) {
            largest = left;
        }
        if (right < heapBody.size() && heapBody.get(right).compareTo(heapBody.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            T temporary = heapBody.get(i);
            heapBody.set(i, heapBody.get(largest));
            heapBody.set(largest, temporary);
            heapify(largest);
        }
    }
}
