package javaCollection;

public class Entry<K, V> {

	private final K key;
	private V value;
	Entry<K, V> next;

	Entry(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
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

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.key.hashCode();
		return hash;
	}
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Entry) && (((Entry) o).getValue() == this.value)) {
			return true;
		} else {
			return false;
		}
	}

}
