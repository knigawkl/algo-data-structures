package mymap;

public class MyMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private static final boolean RED = true;
    //private static final boolean BLACK = false;
    private static final boolean LEFT = true;
    //private static final boolean RIGHT = false;

    private Node root;

    private class Node {

        private K key;
        private V val;
        private Node parent, left, right;
        private boolean color;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }

        private Node getChild(boolean side) {
            return side == LEFT ? parent.left : parent.right;
        }

        private void setChild(Node newChild, boolean side) {
            if (side) {
                this.left = newChild;
            } else {
                this.right = newChild;
            }
        }

        private boolean isRed() {
            return color;
        }

        private void invertColor() {
            this.color = !color;
        }

        private void repaintChildren() {
            this.left.color = !this.left.color;
            this.right.color = !this.right.color;
        }

    }

    private Node rotate(Node rotatedDownwards, boolean side) {
        Node rotatedUpwards = rotatedDownwards.getChild(!side);
        rotatedDownwards.setChild(rotatedUpwards.getChild(side), !side);
        rotatedUpwards.setChild(rotatedUpwards, side);

        changeColorsAfterRotation(rotatedDownwards, rotatedUpwards);

        return rotatedUpwards;
    }

    private void changeColorsAfterRotation(Node rotatedDownwards, Node rotatedUpwards) {
        rotatedUpwards.color = rotatedDownwards.color;
        rotatedDownwards.color = RED;
    }

    @Override
    public void setValue(K key, V value) {

    }

    @Override
    public V getValue(K key) {
        Node current = root;
        while (root != null) {
            int cmp = key.compareTo(current.key);
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
}
