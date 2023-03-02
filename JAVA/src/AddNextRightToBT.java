public class AddNextRightToBT {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(
                1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null
        );

        Node newroot = connect(root);

        System.out.println(newroot);
    }

    public static Node connect(Node root) {
        Node head = root;
        for(;root != null;root = root.left){
            for(Node cur=root;cur != null;cur = cur.next){
                if(cur.left != null){
                    cur.left.next = cur.right;
                    if(cur.next != null){
                        cur.right.next = cur.next.left;
                    }
                }
                else break;

            }
        }
        return head;
    }
}
