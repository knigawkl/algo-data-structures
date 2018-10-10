package generic_heap_sort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> inputArrayList = new ArrayList<>();
        
        inputArrayList.add(9.0);
        inputArrayList.add(8.0);
        inputArrayList.add(7.0);
        inputArrayList.add(6.0);
        inputArrayList.add(5.0);
        inputArrayList.add(4.0);
        inputArrayList.add(3.0);
        inputArrayList.add(2.0);
        inputArrayList.add(1.0);
        inputArrayList.add(0.0);
        inputArrayList.add(10.0);
        
        Heap<Double> heap = new Heap<>(inputArrayList);
        
        HeapSorter heapSorter = new HeapSorter();
        
        System.out.println("Początkowa: ");
        System.out.println(inputArrayList.toString());
        
        double[] doubleArray = new double[inputArrayList.size()];
        int i = 0;
        for(Double d: inputArrayList){
            doubleArray[i] = d.doubleValue();
            i++;
        }
        
        System.out.println("Przekonwertowana:");
        printArray(doubleArray);
        
        System.out.println("Posortowana:");
        heapSorter.sort(doubleArray);
        printArray(doubleArray);
        
    }
    
    public static void printArray(double [] array){
        int n = array.length;
        for(int i = 0; i<n; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
}