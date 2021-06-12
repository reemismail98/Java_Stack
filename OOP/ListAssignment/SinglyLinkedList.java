public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;
    }

    public boolean IsEmpty() {
        return this.head == null;
    }
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner =this.head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }  

   public Integer remove() {
        Node runner = this.head;
        int valueReturn;

        if(IsEmpty())
            return null;

        if(head.next == null) {
            valueReturn = head.value;
            head = null;
            return valueReturn;
        }

        while(runner.next.next != null) {
            runner = runner.next;
        }
        valueReturn = runner.next.value;
        runner.next = null;
        return valueReturn;
        
    }

    public void printValues() {
        if(IsEmpty()) {
            System.out.println("List is empty");
        }

        Node runner = this.head;
        while(runner.next != null) {
            String s = String.format("Node Value: %s :: Next Value: %s", runner.value, runner.next.value);
            System.out.println(s);
            runner = runner.next;
        }
    }
} 