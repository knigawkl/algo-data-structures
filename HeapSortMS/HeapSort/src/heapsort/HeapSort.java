package heapsort;

public class HeapSort implements ListSorterAlgorithm {

    //to se sortuje arraya
    @Override
    public double[] sort(double[] unsortedVector) {
        //wzial se wektor double, teraz  tworzy wektor Double tej samej dlugosci
        Double unsortedCompVector[] = new Double[unsortedVector.length];
        for (int i = 0; i < unsortedVector.length; i++) {
            unsortedCompVector[i] = unsortedVector[i];
        }

        Heap heap = new Heap(unsortedCompVector);

        for (int i = heap.getSize() - 1; i >= 0; i--) {
            unsortedCompVector[i] = (Double) heap.pop();
        }
        for (int i = 0; i < unsortedVector.length; i++) {
            unsortedVector[i] = unsortedCompVector[i];
        }
        return unsortedVector;
    }

}
