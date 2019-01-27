package redblackmap;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedBlackMapTest {

    @Test
    public void testGetValueIntegerFromConstructor() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(1, 9);

        //when
        Integer valueGiven = tested.getValue(1);

        //then
        assertEquals(valueGiven, 9, 0);
    }

    @Test
    public void testGetValueStringFromConstructor() {
        //given
        RedBlackMap<String, String> tested = new RedBlackMap<>("Jacek", "Krzynowek");

        //when
        String valueGiven = tested.getValue("Jacek");

        //then
        assertEquals(valueGiven, "Krzynowek");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNullKey() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(0, 89);

        //when
        tested.setValue(null, 123);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNullValue() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(2, 3);

        //when
        tested.setValue(123, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNullKeyAndValue() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(2, 3);

        //when
        tested.setValue(null, null);
    }

    @Test
    public void testSetValueInteger() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(2, 3);

        //when
        tested.setValue(3, 4);

        //then
        assertEquals(4, tested.getValue(3), 0);
    }

    @Test
    public void testSetValueString() {
        //given
        RedBlackMap<String, String> tested = new RedBlackMap<>("Jacek", "Magiera");

        //when
        tested.setValue("Adam", "Nawałka");

        //then
        assertEquals("Nawałka", tested.getValue("Adam"));
    }

    @Test
    public void testSetValueIntegerKeyAlreadyInMap() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(2, 3);

        //when
        tested.setValue(2, 6);

        //then
        assertEquals(6, tested.getValue(2), 0);
    }

    @Test
    public void testSetValueStringKeyAlreadyInMap() {
        //given
        RedBlackMap<String, String> tested = new RedBlackMap<>("Jacek", "Magiera");

        //when
        tested.setValue("Jacek", "Placek");

        //then
        assertEquals("Placek", tested.getValue("Jacek"));
    }

    @Test
    public void testIsTreeHeightBalanced() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(1, 3);
        int elemCount = 500000;
        for (int i = 0, j = 1; i < elemCount; i++) {
            tested.setValue(i, j++);
        }

        //when
        int treeHeight = tested.getHeight(tested.getRoot());
        double maxBalancedHeight = 2 * Math.log(elemCount + 1) / Math.log(2);

        //then
        assertTrue(treeHeight <= maxBalancedHeight);
    }

    @Test
    public void testIsTreeHeightBalancedRandomKeys() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(1, 3);
        Random random = new Random();
        int elemCount = 500000;
        for (int i = 0; i < elemCount; i++) {
            tested.setValue(random.nextInt(), random.nextInt());
        }

        //when
        int treeHeight = tested.getHeight(tested.getRoot());
        double maxBalancedHeight = 2 * Math.log(elemCount + 1) / Math.log(2);

        //then
        assertTrue(treeHeight <= maxBalancedHeight);
    }

    @Test
    public void testGetHeightOnlyRoot() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(1, 3);

        //when
        int result = tested.getHeight(tested.getRoot());

        //then
        assertEquals(1, result);
    }

    @Test
    public void testSettingValueBiggerThanIntegerMaxValue() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(1, 3);
        tested.setValue(12, Integer.MAX_VALUE + 1);

        //when
        Integer result = tested.getValue(12);

        //then
        assertEquals(-2147483648, result, 0);
    }

    @Test
    public void testBlackNodeCount() {
        //given
        RedBlackMap<String, String> tested = new RedBlackMap<>("a", "a");
        tested.setValue("l", "l");
        tested.setValue("g", "g");
        tested.setValue("o", "o");
        tested.setValue("r", "r");
        tested.setValue("y", "y");
        tested.setValue("t", "t");
        tested.setValue("m", "m");

        //when
        int blackCounter = tested.countBlackNodesPerPath();

        //then
        assertEquals(3, blackCounter);
    }

    @Test
    public void testCountBlackNodesPerPath() {
        //given
        RedBlackMap<Integer, Integer> tested = new RedBlackMap<>(0, 0);
        int elemCount = 10;
        for (int i = 0, j = 1; i < elemCount; i++) {
            tested.setValue(i, j++);
        }

        //when
        int blackCounter = tested.countBlackNodesPerPath();

        //then
        assertEquals(3, blackCounter);
    }
}
