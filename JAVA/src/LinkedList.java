class Node {
    public int data;
    public Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head = null;

    public void push_back(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }

        Node temp = head;

        while(temp.next != null)
            temp = temp.next;

        temp.next = new_node;
    }

    public void push_front(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void push_index(int data, int index){
        Node new_node = new Node(data);
        Node temp = head;

        while(--index > 0)
            temp = temp.next;

        new_node.next = temp.next;
        temp.next = new_node;
    }

    public void print(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}
