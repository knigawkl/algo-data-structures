package sortcomparison;

import java.util.Stack;

public class QuickSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            return null;
        }
        if (unsortedVector.length < 2) {
            return unsortedVector;
        }

        double[] sortedVector = quickSort(unsortedVector);

        return sortedVector;
    }

    private double[] quickSort(double[] vector) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(vector.length - 1);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            int partitionIndex = partition(vector, start, end);

            if (partitionIndex - 1 > start) {
                stack.push(start);
                stack.push(partitionIndex - 1);
            }
            if (partitionIndex + 1 < end) {
                stack.push(partitionIndex + 1);
                stack.push(end);
            }
        }
        return vector;
    }

    private int partition(double[] vector, int firstIndex, int lastIndex) {
        double pivot = vector[firstIndex];
        int firstPtr = firstIndex + 1;
        int scndPtr = lastIndex;
        while (firstPtr < scndPtr) {
            while (firstPtr < scndPtr && vector[firstPtr] <= pivot) {
                firstPtr++;
            }
            while (firstPtr < scndPtr && vector[scndPtr] > pivot) {
                scndPtr--;
            }
            if (firstPtr < scndPtr) {
                swap(vector, firstPtr, scndPtr);
            }
        }
        if (vector[firstPtr] > pivot) {
            firstPtr--;
        }
        swap(vector, firstIndex, firstPtr);
        return firstPtr;
    }

    private void swap(double[] vector, int firstIndex, int scndIndex) {
        double tmp = vector[firstIndex];
        vector[firstIndex] = vector[scndIndex];
        vector[scndIndex] = tmp;
    }

}
