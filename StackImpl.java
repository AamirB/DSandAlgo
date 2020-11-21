
public class StackImpl implements Stacks {

    private Node head ;

    public StackImpl() {

    }

    public void push(int data) {
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }


    public Node pop() throws Exception {

        if(head == null) {
            throw new Exception("Stack Empty cannot pop..");
        }

        Node pop = head;
        head = head.next;
        return pop;

    }

    public Node peek(){
        return head;
    }



    public int search( int data){
        Node curr = head;
        int index = 0;

        while( curr != null){
            if(curr.data == data){
                return index;
            }
            index++;
            curr = curr.next;
        }
        return -1;

    }
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node curr = head;

        while(curr != null && curr.next != null) {
            sb.append(curr.data + "-->");
            curr = curr.next;
        }
        sb.append(curr.data);
        return sb.toString();



    }

    public static void main(String args[]) throws Exception {

        Stacks stack = new StackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        //System.out.println(stack.search(0));


    }


}




