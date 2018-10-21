package mymap;

public class Node<K extends Comparable<K>, V> {

    public static final boolean LEFT = true;
    public static final boolean RIGHT = false;
    public static final boolean RED = true;
    public static final boolean BLACK = true;

    private K key;
    private V val;
    private Node left, right;
    private boolean color;

    Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.color = RED;
    }

    public Node getChild(boolean side) {
        return side == LEFT ? this.left : this.right;
    }

    public void setChild(boolean side, Node newChild) {
        if (side) {
            this.left = newChild;
        } else {
            this.right = newChild;
        }
    }

    public boolean isRed() {
        if (this == null) {
            return false;
        }
        return color;
    }

    public void invertColor() {
        this.color = !color;
    }

    public void repaintChildren() {
        this.left.invertColor();
        this.right.invertColor();
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return this.val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public boolean getColor() {
        return this.color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

}
