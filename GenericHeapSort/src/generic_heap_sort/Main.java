package generic_heap_sort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inputArrayList = new ArrayList<>();

        inputArrayList.add("ala");
        inputArrayList.add("rucha");
        inputArrayList.add("sieszypko");

        //Heap<Double> heap = new Heap<>(inputArrayList);

        HeapSorter heapSorter = new HeapSorter();

        System.out.println("Początkowa: ");
        System.out.println(inputArrayList.toString());

        double[] doubleArray = new double[inputArrayList.size()];
        int i = 0;
        for (Double d : inputArrayList) {
            doubleArray[i] = d;
            i++;
        }

        System.out.println("Przekonwertowana:");
        printArray(doubleArray);

        System.out.println("Posortowana:");
        heapSorter.sort(doubleArray);
        printArray(doubleArray);

    }

    public static void printArray(double[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
