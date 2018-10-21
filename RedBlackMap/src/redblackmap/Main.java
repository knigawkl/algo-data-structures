package redblackmap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void createGraphForSettingValue() {
        try {
            File data = new File("data.txt");
            FileWriter fw = new FileWriter(data);

            RedBlackMap<Integer, Integer> graphed = new RedBlackMap<>(0, 0);
            Random random = new Random();
            int elemCount = 1000000;
            long start, time;
            for (int i = 1, j = 1; i < elemCount; j++) {
                start = System.nanoTime();
                graphed.setValue(random.nextInt(), random.nextInt());
                time = System.nanoTime() - start;
                fw.append(i + "\t" + time + "\n");
                System.out.println(i + "\t" + time);
                if (j % 100 == 0) {
                    i++;
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createGraphForGettingValue() {
        Random rand = new Random();
        System.out.println(rand.nextInt(10));
    }

    public static void main(String[] args) {
        createGraphForSettingValue();
        //createGraphForGettingValue();
    }
}
