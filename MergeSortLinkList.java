import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortLinkList {

    public Node sortLinkList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node midnext = null;
        Node mid = getMidNode(head);
        if (mid != null) {
            midnext = mid.next;
            mid.next = null;
        }
        Node left = sortLinkList(head);
        Node right = null;
        if (midnext != null) {
            right = sortLinkList(midnext);
        }
        head = merge(left, right);
        return head;
    }

    public Node merge(Node left, Node right) {
        Node head = null;
        Node tail = head;
        while (left != null && right != null) {

            if (left.data <= right.data) {

                if (head == null) {
                    head = new Node(left.data);
                    tail = head;
                } else {
                    tail.next = new Node(left.data);
                    tail = tail.next;
                }
                left = left.next;
            } else {

                if (head == null) {
                    head = new Node(right.data);
                    tail = head;
                } else {
                    tail.next = new Node(right.data);
                    tail = tail.next;
                }
                right = right.next;


            }}

            while (left != null) {
                if (head == null) {
                    head = new Node(left.data);
                    tail = head;
                } else {
                    tail.next = new Node(left.data);
                    tail = tail.next;
                }
                left = left.next;
            }


        while (right != null) {
            if (head == null) {
                head = new Node(right.data);
                tail = head;
            } else {
                tail.next = new Node(right.data);
                tail = tail.next;
            }
            right = right.next;

    }
        return head;
    }


    public Node getMidNode(Node head){
        if(head==null || head.next == null || head.next.next == null)
            return head;
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

        }


    public Node mergeAlternateNodes(Node head1, Node head2) {
        Node c = head1;
        while( head1.next != null && head2.next != null) {

            Node temp1 = head1.next;
            Node temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }

        if( head2 != null ){
            head1.next = head2;
        }

        return c;
    }

    public Node retainMdeleteN(int M, int N, Node head) {
        Node curr = head;
        int countM=0;
        int countN=0;
        while( curr != null){
            countM=0;
            countN=0;

            while( countM != M-1 && curr != null){
                curr = curr.next;
                countM++;
            }
            Node prev = curr;
            while( countN != N && curr != null){
                curr = curr.next;
                countN++;
            }
            if(curr != null){
                prev.next = curr.next;
                curr = curr.next;
            }
        }
 return head;

    }

    public Node swapPairWise(Node head) {

        Node curr = head;
        Node prev = null;
        while( curr != null && curr.next != null) {
            Node nextnext = curr.next.next;
            Node next = curr.next;
            curr.next = nextnext;
            next.next = curr;
            if(prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            prev = curr;
            curr = nextnext;
        }
        return head;

    }


    public Node mergekSorted(List<Node> knodes) {



        Node res = new Node(0);
        Node c = res;
        int k = knodes.size();

// memory o(K)
        PriorityQueue<Node> kmin = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data-o2.data;
            }
        });

// Time o(k)
        for(int i=0;i<knodes.size();i++) {
            Node head = knodes.get(i);
            //Node temp = head.next;
           // head.next = null;
            if(head != null) {
                kmin.add(head);
            }
           // head = head.next;
        }

        while(!kmin.isEmpty()){

            Node top = kmin.poll();
            if(top.next != null) {
                kmin.add(top.next);
            }
            res.next = top;
            top.next = null;
            res = res.next;



        }
        return c.next;

    }






    public static void main(String args[]){
        int[] input1 = {1,3,5,7};
        int[] input2 = {2,4,6,8};
        int[] input3 = {0,9,10,11};
        LinkListCopy linklist = new LinkListCopy();
        Node head1 = linklist.create(input1);
        Node head2 = linklist.create(input2);
        Node head3 = linklist.create(input3);
        linklist.printLinkList(head1);
        List<Node> l = new ArrayList<Node>();
        l.add(head1);
        l.add(head2);
        l.add(head3);

        MergeSortLinkList m = new MergeSortLinkList();
        Node head = m.mergekSorted(l);
        linklist.printLinkList(head);
    }

}
