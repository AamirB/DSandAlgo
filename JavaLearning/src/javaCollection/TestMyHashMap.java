package javaCollection;

public class TestMyHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();

		myHashMap.put("Awadh", "SSE");
		myHashMap.put("Rahul", "SSE");
		myHashMap.put("Sattu", "SE");
		myHashMap.put("Gaurav", "SE");

		String e = myHashMap.get("Sattu");
		System.out.println("" + e);
	}

}
