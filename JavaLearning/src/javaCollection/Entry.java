package javaCollection;

public class Entry<K, V> {

	private final K key;
	private V value;
	Entry<K, V> next;

	Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

}
