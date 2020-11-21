package google.graph;

import java.util.HashMap;
import java.util.Map;

//<p>
// *         Find minimum spanning tree usinig Kruskals algorithm
//         *         <p>
// *         Time complexity - O(ElogE)
//         *         Space complexity - O(E + V)
//         *         <p>


public class DisJointSet {

    public class Node {

        int data;
        Node parent;
        int rank;

        Node(int data){
            this.data = data;
            this.rank = 0;
            this.parent = this;
        }
    }

    public Map<Integer, Node> map = new HashMap<>();

    public void makeSet(int data){

       Node node = new Node(data);
       map.put(data, node);

    }

    public Node findSet(Node node){

        Node parent = node.parent;
        if(parent == node){
            return parent;
        }

        node.parent = findSet(node.parent);
        return node.parent;
    }


    public Node findSet(int data){
        return findSet(map.get(data));
    }


    public boolean union(int data1, int data2){

        Node parent1 = findSet(data1);
        Node parent2 = findSet(data2);

        if(parent1 == parent2)
            return false;

        if(parent1.rank == parent2.rank){
            parent2.parent = parent1;
            parent1.rank = parent1.rank + 1;
        } else if(parent1.rank> parent2.rank){
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }

        return true;
    }
}
