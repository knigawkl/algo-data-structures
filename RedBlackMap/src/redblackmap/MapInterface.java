package redblackmap;

public interface MapInterface<K extends Comparable<K>, V> {

    public void setValue(K key, V val);

    public V getValue(K key);
}
