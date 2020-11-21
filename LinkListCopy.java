public class LinkListCopy {



    public Node cloneLinkedList(Node head) {
        if( head == null)
            return null;
        Node newnode = new Node(head.data);
        newnode.next = cloneLinkedList(head.next);
        return newnode;
    }

    public void printLinkList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public int pop(Node head) {

        Node del = head;
        head = head.next;
        return del.data;


    }


    public Node create(int [] input) {

            if(input.length == 0)
                return null;
            Node head = new Node(input[0]);
            Node tail = head;
            for(int i=1;i<input.length;i++) {
                Node newnode = new Node(input[i]);
                tail.next = newnode;
                tail = newnode;
            }

            return head;



        }

    public Node insertNodeInSortedPositions(Node head, Node inserted) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.data< inserted.data) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            inserted.next = head;
            head = inserted;

        } else {
            prev.next = inserted;
            inserted.next = curr;
        }
        return head;



    }


    public static void main(String args[]){
            int[] input = {1,1,3,4,5};
            LinkListCopy linklist = new LinkListCopy();
            Node head = linklist.create(input);
            Node copyLL = linklist.cloneLinkedList(head);
            linklist.printLinkList(copyLL);
            Node newnode = new Node(0);
        Node copyLL1 = linklist.insertNodeInSortedPositions(copyLL, newnode);
        System.out.println();
        linklist.printLinkList(copyLL1);


        }

    }


