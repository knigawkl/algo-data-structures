package sortcomparison;

public class Main {
    
    public static void main(String[] args) {
        Analytics a = new Analytics();
        InsertionSort insort = new InsertionSort();
        QuickSort qsort = new QuickSort();
        MergeSort msort = new MergeSort();
        a.analyseSortingRandomData(insort);
        a.analyseSortingRandomData(qsort);
        a.analyseSortingRandomData(msort);
        a.analyseSortingOptimisticData(insort);
        a.analyseSortingOptimisticData(qsort);
        a.analyseSortingOptimisticData(msort);
        a.analyseSortingPessimisticData(insort);
        a.analyseSortingPessimisticData(qsort);
        a.analyseSortingPessimisticData(msort);
    }
    
}
