package heap;

public class Sorter implements ListSorterAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        int len = unsortedVector.length;
        
        Double[] vector = new Double[len];
        for (int i = 0; i < len; i++) {
            vector[i] = unsortedVector[i];
        }
        
        Heap<Double> heap = new Heap(vector);

        for (int i = heap.getSize() - 1; i >= 0; i--) {
            vector[i] = heap.pop();
        }
        //returned vector will be in ascending order!
        for (int i = 0; i < unsortedVector.length; i++) {
            unsortedVector[i] = (double) vector[i];
        }

        return unsortedVector;
    }
}
