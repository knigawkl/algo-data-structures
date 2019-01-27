package redblackmap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Graph {

    public static final int TESTS_FOR_EACH_N_COUNT = 100000;
    public static final int ELEMENTS_TESTED_COUNT = 1000;
    public static final int GAP_BETWEEN_TESTED_ELEMENTS = 10;

    Random random = new Random();
    RedBlackMap<Integer, Integer> graphed;
    long[] setValueData;
    long[] getValueData;

    public void generateSetValueGraph() {
        setValueData = new long[ELEMENTS_TESTED_COUNT / GAP_BETWEEN_TESTED_ELEMENTS];

        for (int i = 0; i < TESTS_FOR_EACH_N_COUNT; i++) {
            graphed = new RedBlackMap<>(0, 0);
            
            for (int j = 0; j < ELEMENTS_TESTED_COUNT; j++) {
                if (j != 0 && j % GAP_BETWEEN_TESTED_ELEMENTS == 0) {
                    int currentIndex = (j / GAP_BETWEEN_TESTED_ELEMENTS);

                    long duration = measureTimeOfSettingNewVal();

                    setValueData[currentIndex] += duration;
                }
            }
        }
        getAvgTimeOfSetting();

        exportSetValueDataToTxt();
    }

    public void generateGetValueGraph() {
        getValueData = new long[ELEMENTS_TESTED_COUNT / GAP_BETWEEN_TESTED_ELEMENTS];
        for (int i = 0; i < TESTS_FOR_EACH_N_COUNT; i++) {
            graphed = new RedBlackMap<>(0, 0);
            
            for (int j = 0; j < ELEMENTS_TESTED_COUNT; j++) {
                if (j != 0 && j % GAP_BETWEEN_TESTED_ELEMENTS == 0) {
                    int currentIndex = (j / GAP_BETWEEN_TESTED_ELEMENTS);

                    graphed.setValue(random.nextInt(), random.nextInt());

                    long duration = measureTimeOfGettingNewVal();

                    getValueData[currentIndex] += duration;
                }
            }
        }
        getAvgTimeOfGetting();

        exportGetValueDataToTxt();
    }

    private void exportSetValueDataToTxt() {
        try {
            File data = new File("set_value_data.txt");
            FileWriter fw = new FileWriter(data);

            for (int i = 0; i < setValueData.length; i++) {
                fw.append(i * GAP_BETWEEN_TESTED_ELEMENTS + "\t" + setValueData[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportGetValueDataToTxt() {
        try {
            File data = new File("get_value_data.txt");
            FileWriter fw = new FileWriter(data);

            for (int i = 0; i < getValueData.length; i++) {
                fw.append(i * GAP_BETWEEN_TESTED_ELEMENTS + "\t" + getValueData[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAvgTimeOfSetting() {
        for (int n = 0; n < setValueData.length; n++) {
            setValueData[n] = setValueData[n] / TESTS_FOR_EACH_N_COUNT;
        }
    }

    private void getAvgTimeOfGetting() {
        for (int n = 0; n < getValueData.length; n++) {
            getValueData[n] = getValueData[n] / TESTS_FOR_EACH_N_COUNT;
        }
    }

    private long measureTimeOfSettingNewVal() {
        long start, end;
        start = System.nanoTime();
        graphed.setValue(random.nextInt(), random.nextInt());
        end = System.nanoTime();

        return end - start;
    }

    private long measureTimeOfGettingNewVal() {
        long start, end;
        start = System.nanoTime();
        graphed.getValue(random.nextInt());
        end = System.nanoTime();

        return end - start;
    }
}
