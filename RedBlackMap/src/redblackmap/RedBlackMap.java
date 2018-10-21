package redblackmap;

public class RedBlackMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

    public static final boolean LEFT = true;
    public static final boolean RIGHT = false;
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;

    public class Node {

        private K key;
        private V val;
        private Node left, right;
        private boolean color;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }

        Node(K key, V val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }

        private void invertColor() {
            this.color = !color;
        }

        private void repaintChildren() {
            this.left.invertColor();
            this.right.invertColor();
        }
    }

    public RedBlackMap(K key, V val) {
        root = new Node(key, val, BLACK);
    }

    @Override
    public V getValue(K searchedKey) {
        isKeyNull(searchedKey);

        Node current = root;

        while (current != null) {
            int cmp = searchedKey.compareTo(current.key);
            if (cmp == 0) {
                return current.val;
            } else if (cmp > 0) {
                current = current.right;
            } else if (cmp < 0) {
                current = current.left;
            }
        }
        return null;
    }

    @Override
    public void setValue(K key, V val) {
        isKeyNull(key);
        isValNull(val);

        root = setValue(key, val, root);

        if (isRed(root)) {
            root.invertColor();
        }
    }

    private Node setValue(K key, V value, Node subroot) {
        if (subroot == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(subroot.key);
        if (cmp < 0) {
            subroot.left = setValue(key, value, subroot.left);
        } else if (cmp > 0) {
            subroot.right = setValue(key, value, subroot.right);
        } else {
            subroot.val = value;
        }

        subroot = removeRightRedChildren(subroot);

        return subroot;
    }

    private Node removeRightRedChildren(Node current) {
        if (!isRed(current.left) && isRed(current.right)) {
            current = rotate(current, LEFT);
        }
        if (isRed(current.left) && isRed(current.left.left)) {
            current = rotate(current, RIGHT);
        }
        if (isRed(current.left) && isRed(current.right)) {
            current.invertColor();
            current.repaintChildren();
        }
        return current;
    }

    private Node rotate(Node rotatedDownwards, boolean side) {
        Node rotatedUpwards = side == LEFT ? rotatedDownwards.right : rotatedDownwards.left;
        if (side) {
            rotatedDownwards.right = rotatedUpwards.left;
            rotatedUpwards.left = rotatedDownwards;
        } else {
            rotatedDownwards.left = rotatedUpwards.right;
            rotatedUpwards.right = rotatedDownwards;
        }

        changeColorsAfterRotation(rotatedDownwards, rotatedUpwards);

        return rotatedUpwards;
    }

    private void changeColorsAfterRotation(Node rotatedDownwards, Node rotatedUpwards) {
        rotatedUpwards.color = rotatedDownwards.color;
        rotatedDownwards.color = RED;
    }

    private void isKeyNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
    }

    private void isValNull(V val) {
        if (val == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public Node getRoot() {
        return this.root;
    }

    public int countBlackNodesPerPath() {
        int blackCount = 0;
        Node subroot = root;
        while (subroot != null) {
            if (!isRed(subroot)) {
                blackCount++;
            }
            subroot = subroot.left;
        }
        return blackCount;
    }
}
