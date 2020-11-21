import java.util.*;

public class LRU {


    int capacity;
    Deque<Integer> deque = new LinkedList<>();
    Set<Integer> numContainer = new HashSet<Integer>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }


    public void refer(Integer num) {
            if(numContainer.contains(num)){
                deque.removeLastOccurrence(num);
                 deque.push(num);
            }


            else {

                if(deque.size()==capacity){
                    deque.removeLast();
                     deque.push(num);
                } else {
                    capacity++;
                     deque.push(num);
                }
                numContainer.add(num);
            }
    }

    public void display(){
        Iterator<Integer> itr = deque.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next()+ " ");
        }
    }
    public static void main(String[] args)
    {
        LRU ca = new LRU(2);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }



}


