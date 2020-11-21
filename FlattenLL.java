public class FlattenLL {



    public MultiLLNode flattenLinkList(MultiLLNode head) {

        MultiLLNode tail = head;
        while(tail != null && tail.next != null) {
            tail = tail.next;
        }

        MultiLLNode curr = head;
        while(curr != null) {
            MultiLLNode next = curr.next;
            tail.next = curr.child;
            curr.child.prev = tail;
            curr.child = null;
            curr = next;

            while(tail != null && tail.next != null) {
                tail = curr.next;
            }
        }

        return head;

    }


    public static void main(String args[]) {

        MultiLLNode head = new MultiLLNode(5);
        head.next = new MultiLLNode(33);
        head.next.next = new MultiLLNode(17);
        head.next.next.next = new MultiLLNode(2);
        head.next.next.next.next = new MultiLLNode(1);
        //head.child

    }

}
