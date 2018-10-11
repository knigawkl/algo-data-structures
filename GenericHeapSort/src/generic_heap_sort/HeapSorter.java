package generic_heap_sort;

public class HeapSorter implements ListSorterAlgorithm{

    @Override
    public double[] sort(double[] unsortedVector) {
        int heapSize = unsortedVector.length;
        int parent = (heapSize)/2-1;
        while(parent>=0){
            validateMaxHeap(unsortedVector,heapSize, parent--);
        }
        for(int i = heapSize-1; i>0;i--){
            swap(unsortedVector, 0, i);
            heapSize--;
            validateMaxHeap(unsortedVector, heapSize, 0);
        }
        
        return unsortedVector;
    }
    
    public void validateMaxHeap(double[] unsortedVector,int heapSize, int parent){
        int leftChild = 2*parent +1;
        int rightChild = 2*parent+2;
        int maxIndex = parent;
        
        if(parent<0)
            return;
        if(rightChild<heapSize && unsortedVector[maxIndex]<unsortedVector[rightChild]){
            maxIndex = rightChild;
        }
        if(leftChild<heapSize && unsortedVector[maxIndex]<unsortedVector[leftChild]){
            maxIndex = leftChild;
        }
        if(maxIndex!=parent){
            swap(unsortedVector, maxIndex, parent);
            validateMaxHeap(unsortedVector, heapSize, maxIndex);
        }
    }
    
    public static void swap(double [] array, int a, int b){
        double tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    
}