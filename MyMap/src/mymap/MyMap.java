package mymap;

public class MyMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

    public static final boolean LEFT = true;
    public static final boolean RIGHT = false;
    public static final boolean RED = true;
    public static final boolean BLACK = true;
    
    private Node<K, V> root;

    public MyMap(K key, V val) {
        root = new Node<>(key, val);
    }

    private Node rotate(Node<K, V> rotatedDownwards, boolean side) {
        Node rotatedUpwards = rotatedDownwards.getChild(!side);
        rotatedDownwards.setChild(!side, rotatedUpwards.getChild(side));
        rotatedUpwards.setChild(side, rotatedDownwards);

        changeColorsAfterRotation(rotatedDownwards, rotatedUpwards);

        return rotatedUpwards;
    }

    private void changeColorsAfterRotation(Node<K, V> rotatedDownwards, Node<K, V> rotatedUpwards) {
        rotatedUpwards.setColor(rotatedDownwards.getColor());
        rotatedDownwards.setColor(RED);
    }

    @Override
    public void setValue(K key, V val) {
        checkForNullArgs(key, val);

        root = setValue(key, val, root);

        if (root.isRed()) {
            root.invertColor();
        }

    }

    private Node setValue(K key, V val, Node<K, V> subroot) {
        if (subroot == null) {
            return new Node<>(key, val);
        }
        
        int cmp = key.compareTo(subroot.getKey());
        if (cmp == 0) {
            subroot.setVal(val);
        } else if (cmp > 0) {
            subroot.setChild(RIGHT, setValue(key, val, subroot.getChild(RIGHT)));
        } else {
            subroot.setChild(LEFT, setValue(key, val, subroot.getChild(LEFT)));
        } /*
        if (!subroot.getChild(LEFT).isRed() && subroot.getChild(RIGHT).isRed()) {
            subroot = rotate(subroot, LEFT);
        } */
        if (subroot.getChild(LEFT).getChild(LEFT).isRed() && subroot.getChild(RIGHT).isRed()) {
            subroot = rotate(subroot, RIGHT);
        }  /*
        if (subroot.getChild(LEFT).isRed() && subroot.getChild(RIGHT).isRed()) {
            subroot.invertColor();
            subroot.repaintChildren();
        }
*/
        return subroot;
   }

    //private void findPositionInTheTree
    @Override
    public V getValue(K searchedKey) {
        if (searchedKey == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }

        Node<K, V> current = root;

        while (current != null) {
            int cmp = searchedKey.compareTo(current.getKey());
            if (cmp == 0) {
                return current.getVal();
            } else if (cmp > 0) {
                current = current.getChild(RIGHT);
            } else if (cmp < 0) {
                current = current.getChild(LEFT);
            }
        }

        return null;
    }

    private void checkForNullArgs(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        if (val == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }
}
