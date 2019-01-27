package sortcomparison;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    private QuickSort qsorter = new QuickSort();
    private Random random;

    @Test
    public void testEmptyArray() {
        //given
        double[] tested = {};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{}, 0);
    }

    @Test
    public void testNullArray() {
        //given
        double[] tested = null;

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, null, 0);
    }

    @Test
    public void testOneElemArray() {
        //given
        double[] tested = {1.0};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.0}, 0);
    }

    @Test
    public void testShortArrayEvenNumOfElems() {
        //given
        double[] tested = {1.5, 34.0, 7.8, 44.0};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.5, 7.8, 34.0, 44.0}, 0);
    }

    @Test
    public void testShortArrayOddNumOfElems() {
        //given
        double[] tested = {1.3, 2.6, 6.4, 34.0, 7.3};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.3, 2.6, 6.4, 7.3, 34.0}, 0);
    }

    @Test
    public void testLongerArrayEvenNumOfElems() {
        //given
        double[] tested = {1.3, 2.5, 6.6, 34.8, 7.0, 345.0, 87.4, 34.6, 85.3, 2.1, 76.9, 5.4, 76.2, 65.6};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.3, 2.1, 2.5, 5.4, 6.6, 7.0, 34.6, 34.8, 65.6, 76.2, 76.9, 85.3, 87.4, 345.0}, 0);
    }

    @Test
    public void testLongerArrayOddNumOfElems() {
        //given
        double[] tested = {1.0, 2.5, 6.9, 34.3, 7.5, 345.1, 87.6, 85.9, 2.4, 76.6, 5.4, 76.5, 65.5};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.0, 2.4, 2.5, 5.4, 6.9, 7.5, 34.3, 65.5, 76.5, 76.6, 85.9, 87.6, 345.1}, 0);
    }

    @Test
    public void testArraySortedButReversed() {
        //given
        double[] tested = {9.8, 8.5, 7.4, 6.3, 5.6, 4.2, 3.1, 2.4, 1.5};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.5, 2.4, 3.1, 4.2, 5.6, 6.3, 7.4, 8.5, 9.8}, 0);
    }

    @Test
    public void testArrayAlreadySorted() {
        //given
        double[] tested = {1.5, 2.4, 3.1, 4.2, 5.6, 6.3, 7.4, 8.5, 9.8};

        //when
        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, new double[]{1.5, 2.4, 3.1, 4.2, 5.6, 6.3, 7.4, 8.5, 9.8}, 0);
    }

    @Test
    public void testLargeArray() {
        //given
        int largeCapacity = 100000;
        double[] sorted = new double[largeCapacity];
        double[] tested = new double[largeCapacity];

        //when
        for (int i = 0; i < largeCapacity; i++) {
            sorted[i] = i;
        }

        for (int i = 0, j = largeCapacity - 1; i < largeCapacity; i++, j--) {
            tested[i] = sorted[j];
        }

        tested = qsorter.sort(tested);

        //then
        assertArrayEquals(tested, sorted, 0);
    }

    @Test
    public void testShortRandomArrayEvenNumOfElems() {
        //given
        random = new Random();
        double[] sorted = new double[10];

        //when
        for (int i = 0; i < 10; i++) {
            sorted[i] = random.nextDouble();
        }

        double[] tested = qsorter.sort(sorted);
        java.util.Arrays.sort(sorted);

        //then
        assertArrayEquals(tested, sorted, 0);
    }

    @Test
    public void testShortRandomArrayOddNumOfElems() {
        //given
        random = new Random();
        double[] sorted = new double[9];

        //when
        for (int i = 0; i < 9; i++) {
            sorted[i] = random.nextDouble();
        }

        double[] tested = qsorter.sort(sorted);
        java.util.Arrays.sort(sorted);

        //then
        assertArrayEquals(tested, sorted, 0);
    }

    @Test
    public void testLongerRandomArrayEvenNumOfElems() {
        //given
        random = new Random();
        double[] sorted = new double[1000];

        //when
        for (int i = 0; i < 1000; i++) {
            sorted[i] = random.nextDouble();
        }

        double[] tested = qsorter.sort(sorted);
        java.util.Arrays.sort(sorted);

        //then
        assertArrayEquals(tested, sorted, 0);
    }

    @Test
    public void testLongerRandomArrayOddNumOfElems() {
        //given
        random = new Random();
        double[] sorted = new double[999];

        //when
        for (int i = 0; i < 999; i++) {
            sorted[i] = random.nextDouble();
        }

        double[] tested = qsorter.sort(sorted);
        java.util.Arrays.sort(sorted);

        //then
        assertArrayEquals(tested, sorted, 0);
    }

    @Test
    public void testSameElemsArray() {
        //given
        random = new Random();
        double[] sorted = new double[10];

        //when
        for (int i = 0; i < 10; i++) {
            sorted[i] = 1;
        }

        //then
        assertArrayEquals(sorted, new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0);
    }
    
}
