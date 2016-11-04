package javaCollection;

public class MyHashMap<K, V> {

	private final int SIZE = 16;
	private Entry<K, V> table[];

	public MyHashMap() {
		table = new Entry[SIZE];
	}
	public void put(K key, V value) {

		int hash = key.hashCode() % SIZE;
		Entry<K, V> e = table[hash];

		if (e != null) {

			while (e != null) {

				if (e.getKey().equals(key)) {
					e.setValue(value);
					return;
				}
				e = e.next;
			}
			Entry<K, V> newE = new Entry(key, value);
			e.next = newE;

		} else {
			Entry<K, V> newE = new Entry(key, value);
			table[hash] = newE;
			return;
		}

	}

	public V get(K key) {
		int hash = key.hashCode() % SIZE;

		Entry<K, V> e = table[hash];

		while (e != null) {

			if (e.getKey().equals(key))
				return e.getValue();
			e = e.next;
		}

		return null;
	}

	public V remove(K key) {
		int hash = key.hashCode() % SIZE;

		Entry<K, V> e = table[hash];
		Entry<K, V> prev = null;
		while (e != null) {
			if (e.getKey().equals(key)) {
				Entry<K, V> r = e;
				prev.next = e.next;
				return r.getValue();
			}
			prev = e;
			e = e.next;

		}
		return null;
	}
}
