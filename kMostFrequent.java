import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class kMostFrequent {





    public static void main(String args[]) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};

        int k = 3;

        TreeSet<Element> e = new TreeSet<Element>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.count == o2.count) {
                    return o1.number - o2.number;
                }
                return o1.count - o2.count;
            }
        });



        for(int i=0;i<arr.length;i++) {
                Element n = new Element(arr[i]);
            if(e.contains(n)){
              int count = n.getCount();
              e.add(new Element(arr[i],count+1));
            } else {
                e.add(new Element(arr[i],1));
            }
        }

System.out.println(e);

    }
}
