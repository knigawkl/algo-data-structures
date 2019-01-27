package sortcomparison;

public class MergeSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            return null;
        }
        if (unsortedVector.length < 2) {
            return unsortedVector;
        }

        double[] sortedVector = mergeSort(unsortedVector);

        return sortedVector;
    }

    private double[] mergeSort(double[] vector) {
        int len = vector.length;

        for (int currentSize = 1; currentSize <= len - 1; currentSize = 2 * currentSize) {

            for (int left = 0; left < len - 1; left += 2 * currentSize) {

                int mid = Math.min(left + currentSize - 1, len - 1);
                int right = Math.min(left + 2 * currentSize - 1, len - 1);

                merge(vector, left, mid, right);
            }
        }
        return vector;
    }

    private void merge(double[] vector, int firstIndex, int middleIndex, int lastIndex) {
        int firstHalfLength = middleIndex - firstIndex + 1;
        int scndHalfLength = lastIndex - middleIndex;

        double firstHalf[] = new double[firstHalfLength];
        double scndHalf[] = new double[scndHalfLength];

        for (int i = 0; i < firstHalfLength; i++) {
            firstHalf[i] = vector[firstIndex + i];
        }
        for (int j = 0; j < scndHalfLength; j++) {
            scndHalf[j] = vector[middleIndex + 1 + j];
        }

        int firstHalfPtr = 0, scndHalfPtr = 0, k = firstIndex; 
        
        while (firstHalfPtr < firstHalfLength && scndHalfPtr < scndHalfLength) {
            if (firstHalf[firstHalfPtr] <= scndHalf[scndHalfPtr]) {
                vector[k++] = firstHalf[firstHalfPtr++];
            } else {
                vector[k++] = scndHalf[scndHalfPtr++];
            }
        }

        while (firstHalfPtr < firstHalfLength) {
            vector[k++] = firstHalf[firstHalfPtr++];
        }
        while (scndHalfPtr < scndHalfLength) {
            vector[k++] = scndHalf[scndHalfPtr++];
        }
    }

}
