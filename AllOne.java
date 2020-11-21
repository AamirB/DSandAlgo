package tree;


import java.util.*;

class AllOne {


    public static void main(String args[]){
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("hello");
        allOne.inc("hello1");
        allOne.dec("hello");
        System.out.println(allOne.valueTokey);
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }


    Map<String,Integer> keyTovalue = new HashMap<>();
    TreeMap<Integer, Set<String>> valueTokey = new TreeMap<>();


    /** Initialize your data structure here. */
    public AllOne() {

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

        int value = keyTovalue.getOrDefault(key,0)+1;
        keyTovalue.put(key,value);
        if(valueTokey.get(value) == null) {
            valueTokey.put(value, new HashSet<>());
        }

        if(value == 1) {
            valueTokey.get(value).add(key);
        } else {
            valueTokey.get(value).add(key);
            valueTokey.get(value-1).remove(key);
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

        if(keyTovalue.get(key) == null) {
            return;
        }

        if(keyTovalue.get(key) == 1) {
            keyTovalue.remove(key);
            valueTokey.get(1).remove(key);
        } else {

            int value = keyTovalue.get(key);
            keyTovalue.put(key,value-1);
            valueTokey.get(value).remove(key);
            if(valueTokey.get(value).isEmpty()){
                valueTokey.remove(key);
            }
            if(valueTokey.get(value-1) == null) {
                valueTokey.put(value-1, new HashSet<>());
            }
            valueTokey.get(value-1).add(key);


        }
    }

    // TODO doubt if TreeMap has order 1 complexity for first or last entry
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {

        if(valueTokey.isEmpty() || valueTokey.lastEntry().getValue().isEmpty()){
            return "";
        }
        return valueTokey.lastEntry().getValue().stream().findFirst().get();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(valueTokey.isEmpty() || valueTokey.firstEntry().getValue().isEmpty()){
            return "";
        }
        return valueTokey.firstEntry().getValue().stream().findFirst().get();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */