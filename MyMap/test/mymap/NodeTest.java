package mymap;

import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testGetChildLeft() {
        //given
        Node<Integer, Integer> testedInteger = new Node<>(8, 8);
        Node<String, String> testedString = new Node<>("1", "first");    
        
        //when
        Node<Integer, Integer> addedIntegerChild = new Node<>(10, 10);
        testedInteger.setChild(Node.LEFT, addedIntegerChild);
        Node<String, String> addedStringChild = new Node<>("2", "second"); 
        testedString.setChild(Node.LEFT, addedStringChild);
        
        //then
        assertEquals(testedInteger.getChild(Node.LEFT), addedIntegerChild);
        assertEquals(testedString.getChild(Node.LEFT), addedStringChild);
    }
    
    @Test
    public void testGetChildRight() {
        //given
        Node<Integer, Integer> testedInteger = new Node<>(3, 3);
        Node<Float, Float> testedFloat = new Node<>(3.641f, 3.36263f);      
                        
        //when
        Node<Integer, Integer> addedIntegerChild = new Node<>(5, 5);
        testedInteger.setChild(Node.RIGHT, addedIntegerChild);
        Node<Float, Float> addedFloatChild = new Node<>(3.23564f, 3.673548f);
        testedFloat.setChild(Node.RIGHT, addedFloatChild);
        
        //then
        assertEquals(testedInteger.getChild(Node.RIGHT), addedIntegerChild);
        assertEquals(testedFloat.getChild(Node.RIGHT), addedFloatChild);
    }

    @Test
    public void testSetChildLeft() {
        //given
        Node<String, String> testedString = new Node<>("1", "first");
        Node<String, String> addedString = new Node<>("3", "third");
        
        //when
        testedString.setChild(Node.LEFT, addedString);
        
        //then
        assertEquals(testedString.getChild(Node.LEFT), addedString);
    }
    
    @Test
    public void testSetChildRight() {
        //given
        Node<String, String> testedString = new Node<>("1", "inzynier");
        Node<String, String> addedString = new Node<>("2", "magister");
        
        //when
        testedString.setChild(Node.RIGHT, addedString);
        
        //then
        assertEquals(testedString.getChild(Node.RIGHT), addedString);
    }

    @Test
    public void testGetKey() {
        //given
        Node<Integer, Integer> tested = new Node<>(8, 8);
        
        //when
        Integer keyGiven = tested.getKey();
        
        //then
        assertEquals(keyGiven, 8, 0);
    }

    @Test
    public void testSetKey() {
        //given
        Node<Integer, Integer> tested = new Node<>(8, 8);
        
        //when
        tested.setKey(123);
        
        //then
        assertEquals(tested.getKey(), 123, 0);
    }

    @Test
    public void testGetVal() {
        //given
        Node<Double, Double> tested = new Node<>(12.3, 12.4);
        
        //when
        Double result = tested.getVal();
        
        //then
        assertEquals(12.4, result, 0);
    }

    @Test
    public void testSetVal() {
        //given
        Node<String, String> tested = new Node<>("Lukasz", "Knigawka");
        
        //when
        tested.setVal("Lewandowski");
        
        //then
        assertEquals(tested.getVal(), "Lewandowski");
    }
    
}
