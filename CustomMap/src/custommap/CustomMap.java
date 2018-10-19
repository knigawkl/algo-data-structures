package custommap;

/* this is heavily based on Sedgewick's implementation */

public class CustomMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        private K key;
        private V val;
        private Node left, right;
        private boolean color;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }
    }

    @Override
    public void setValue(K key, V value) {
        root = setValue(root, key, value);
        root.color = BLACK; //eventually the root must be always black
    }

    private Node setValue(Node h, K key, V val) {
        if (h == null) {
            return new Node(key, val);
        }

        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        int cmp = key.compareTo(h.key);
        if (cmp == 0) {
            h.val = val;
        } else if (cmp < 0) {
            h.left = setValue(h.left, key, val);
        } else {
            h.right = setValue(h.right, key, val);
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        return h;
    }

    @Override
    public V getValue(K key) {
        if (key == null) {
            return null;
        }
        return getValue(root, key);
    }

    private V getValue(Node x, K key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return (x.color == RED);
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        //set up the right colors
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        //set up the right colors
        x.color = RED;
        return x;
    }

    public static void main(String[] args) {

    }

}
