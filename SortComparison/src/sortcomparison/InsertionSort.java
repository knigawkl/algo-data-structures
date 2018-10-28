package sortcomparison;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            return null;
        }
        
        double[] sortedVector = unsortedVector;
        int len = sortedVector.length;

        for (int i = 1; i < len; i++) {
            double key = sortedVector[i];
            int j = i - 1;

            while (j >= 0 && sortedVector[j] > key) {
                sortedVector[j + 1] = sortedVector[j];
                j--;
            }

            sortedVector[j + 1] = key;
        }

        return sortedVector;
    }

}
