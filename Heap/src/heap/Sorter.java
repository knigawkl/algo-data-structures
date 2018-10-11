package heap;

public class Sorter implements ListSorterAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        int n = unsortedVector.length;

        for (int i = (n - 1) / 2; i >= 0; i--) {
            recreateMaxHeap(unsortedVector, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(unsortedVector, 0, i);
            recreateMaxHeap(unsortedVector, --n, 0);
        }
        return unsortedVector;
    }
    //validates if the heap is a max-heap, if not, restructures the heap
    public void recreateMaxHeap(double[] array, int heapSize, int parentIndex) {
        int maxIndex = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[maxIndex]) {
            maxIndex = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[maxIndex]) {
            maxIndex = rightChild;
        }

        if (maxIndex != parentIndex) {
            swap(array, maxIndex, parentIndex);
            recreateMaxHeap(array, heapSize, maxIndex);
        }
    }
    //swaps two elems inside an array : double
    public void swap(double[] array, int index1, int index2) {
        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
