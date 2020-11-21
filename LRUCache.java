import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {


    private Deque<Integer> deque; //Store keys in order LRU
    private Map<Integer,Integer> container; //store keys to value mapping
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity ;
        this.deque = new LinkedList<>();
        this.container = new HashMap<>();
    }

    public int get(int key) {
        Integer val = container.get(key);
        if( val == null){
            return -1;
        }
        deque.removeLastOccurrence(key);
        deque.push(key);
        //deque.las
        System.out.println(val);
        return val;
    }

    public void put(int key, int value) {
        Integer val = container.get(key);
        if( val != null) {
            deque.removeLastOccurrence(key);
            deque.push(key);

            container.put(key,value);
        } else if(deque.size() == capacity) {
            Integer expired = deque.removeLast();
            container.remove(expired);
            deque.push(key);
            container.put(key,value);
        } else {
            deque.push(key);
            container.put(key,value);
            //capacity++;
        }

    }


    public static void main(String args[]){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }
}

