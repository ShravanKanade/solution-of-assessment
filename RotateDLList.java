class Practice {
    class Node{
        int data;
        Node previous;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    int size = 0;
    Node head, tail = null;
    public void addNode(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }
    public void rotateList(int n) {
        Node current = head;
        if(n == 0 || n >= size)
            return;
        else {
            for(int i = 1; i < n; i++)
                current = current.next;
            tail.next = head;
            head = current.next;
            head.previous = null;
            tail = current;
            tail.next = null;
        }
    }
    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Practice dl = new Practice();
        //Add nodes to the list  
        dl.addNode(1);
        dl.addNode(2);
        dl.addNode(3);
        dl.addNode(4);
        dl.addNode(5);
        System.out.println("Original List: ");
        dl.display();
        dl.rotateList(3);
        System.out.println("Updated List: ");
        dl.display();
    }
}  
