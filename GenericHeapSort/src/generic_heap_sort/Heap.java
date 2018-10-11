package generic_heap_sort;

import java.util.ArrayList;

public class Heap <T extends Comparable<T>> implements HeapInterface<T>{
    ArrayList<T> elements;
    HeapSorter heapSorter;

    public ArrayList<T> getElements() {
        return elements;
    }

    public Heap(ArrayList<T> heapTable) {
        elements = heapTable;
        heapSorter = new HeapSorter();
    }

    @Override
    public void put(T item) {
        elements.add(item);
        heapUpElement(elements, elements.size()-1);
    }
    
    public void heapUpElement(ArrayList<T> arrayList, int index){
        int parentIndex = (index-1)/2;
        if(parentIndex>=0 && arrayList.get(parentIndex).compareTo(arrayList.get(index))==-1){
            swap(arrayList, parentIndex, index);
            heapUpElement(arrayList, parentIndex);
        }
    }    
    
    public void swap(ArrayList<T> elements, int a, int b){
        T tmp = elements.get(a);
        elements.add(a, elements.get(b));
        elements.remove(a+1);
        elements.add(b, tmp);
        elements.remove(b+1);
    }

    @Override
    public T pop() {
        T max = elements.get(0);
        swap(elements, 0, elements.size()-1);
        elements.remove(elements.size()-1);
        
        double[] doubleArray = new double[elements.size()];
        int i = 0;
        
        heapSorter.sort(doubleArray);
        return max;
    }  
    
}