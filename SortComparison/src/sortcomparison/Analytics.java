package sortcomparison;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Analytics {

    public static final int TESTS_FOR_EACH_N_COUNT = 1000;
    public static final int ELEMENTS_TESTED_COUNT = 1000;
    private Random random;

    public Analytics() {
        random = new Random();
    }

    public void analyseSortingRandomData(SortingAlgorithm sortingAlgorithm) {
        long[] randomDataSortingResults = new long[ELEMENTS_TESTED_COUNT];
        random = new Random();

        for (int i = 0; i < TESTS_FOR_EACH_N_COUNT; i++) {
            List<Double> analysed = new ArrayList<Double>();

            for (int j = 0; j < ELEMENTS_TESTED_COUNT; j++) {
                if (j != 0) {
                    analysed.add(random.nextDouble());
                    double[] analysedPrim = new double[analysed.size()];
                    for (int m = 0; m < analysedPrim.length; m++) {
                        analysedPrim[m] = analysed.get(m).doubleValue();
                    }
                    long duration = measureSortingTime(analysedPrim, sortingAlgorithm);

                    randomDataSortingResults[j] += duration;
                }
            }
        }
        getAvgTime(randomDataSortingResults);

        if (sortingAlgorithm.getClass() == InsertionSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/random_insort.txt");
        } else if (sortingAlgorithm.getClass() == QuickSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/random_qsort.txt");
        } else {
            exportDataToTxt(randomDataSortingResults, "txt_data/random_msort.txt");
        }
    }

    public void analyseSortingOptimisticData(SortingAlgorithm sortingAlgorithm) {
        long[] randomDataSortingResults = new long[ELEMENTS_TESTED_COUNT];
        random = new Random();

        for (int i = 0; i < TESTS_FOR_EACH_N_COUNT; i++) {
            List<Double> analysed = new ArrayList<Double>();

            for (int j = 0; j < ELEMENTS_TESTED_COUNT; j++) {
                if (j != 0) {
                    analysed.add((double) j);
                    double[] analysedPrim = new double[analysed.size()];
                    for (int m = 0; m < analysedPrim.length; m++) {
                        analysedPrim[m] = analysed.get(m).doubleValue();
                    }
                    long duration = measureSortingTime(analysedPrim, sortingAlgorithm);

                    randomDataSortingResults[j] += duration;
                }
            }
        }
        getAvgTime(randomDataSortingResults);

        if (sortingAlgorithm.getClass() == InsertionSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/asc_insort.txt");
        } else if (sortingAlgorithm.getClass() == QuickSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/asc_qsort.txt");
        } else {
            exportDataToTxt(randomDataSortingResults, "txt_data/asc_msort.txt");
        }
    }

    public void analyseSortingPessimisticData(SortingAlgorithm sortingAlgorithm) {
        long[] randomDataSortingResults = new long[ELEMENTS_TESTED_COUNT];
        random = new Random();

        for (int i = 0; i < TESTS_FOR_EACH_N_COUNT; i++) {
            List<Double> analysed = new ArrayList<Double>();

            for (int j = 0; j < ELEMENTS_TESTED_COUNT; j++) {
                if (j != 0) {
                    analysed.add((double) ELEMENTS_TESTED_COUNT - j);
                    double[] analysedPrim = new double[analysed.size()];
                    for (int m = 0; m < analysedPrim.length; m++) {
                        analysedPrim[m] = analysed.get(m).doubleValue();
                    }
                    long duration = measureSortingTime(analysedPrim, sortingAlgorithm);

                    randomDataSortingResults[j] += duration;
                }
            }
        }
        getAvgTime(randomDataSortingResults);

        if (sortingAlgorithm.getClass() == InsertionSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/dsc_insort.txt");
        } else if (sortingAlgorithm.getClass() == QuickSort.class) {
            exportDataToTxt(randomDataSortingResults, "txt_data/dsc_qsort.txt");
        } else {
            exportDataToTxt(randomDataSortingResults, "txt_data/dsc_msort.txt");
        }
    }

    private long measureSortingTime(double[] vector, SortingAlgorithm sortingAlgorithm) {
        long start, end;

        start = System.nanoTime();
        sortingAlgorithm.sort(vector);
        end = System.nanoTime();

        return end - start;
    }

    private void getAvgTime(long[] data) {
        for (int n = 0; n < data.length; n++) {
            data[n] /= TESTS_FOR_EACH_N_COUNT;
        }
    }

    private void exportDataToTxt(long[] data, String filename) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);

            for (int i = 0; i < data.length; i++) {
                fw.append(i + "\t" + data[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
