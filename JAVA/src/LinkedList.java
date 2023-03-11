class ListNode {
    public int val;
    public ListNode next;

    ListNode(){
        this.val = 0;
        this.next = null;
    }
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head = null;

    public void push_back(int data){
        ListNode new_List_node = new ListNode(data);
        if(head == null){
            head = new_List_node;
            return;
        }

        ListNode temp = head;

        while(temp.next != null)
            temp = temp.next;

        temp.next = new_List_node;
    }

    public void push_front(int data){
        ListNode new_List_node = new ListNode(data);
        new_List_node.next = head;
        head = new_List_node;
    }

    public void push_index(int data, int index){
        ListNode new_List_node = new ListNode(data);
        ListNode temp = head;

        while(--index > 0)
            temp = temp.next;

        new_List_node.next = temp.next;
        temp.next = new_List_node;
    }

    public void print(){
        ListNode temp = head;

        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }
}
