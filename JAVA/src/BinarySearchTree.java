public class BinarySearchTree {
    private class BinaryNode{
        public int data;
        public BinaryNode right, left;

        BinaryNode(int data){
            this.data = data;
            right = left = null;
        }
    }

    BinaryNode insert(int value, BinaryNode root) {
        if(root == null)
            return new BinaryNode(value);
        if(value < root.data)
            root.left = insert(value, root.left);
        else if(root.data < value)
            root.right = insert(value, root.right);

        return root;
    }
    BinaryNode delete(int value, BinaryNode root){
        if(root == null)
            return null;
        if(root.data == value){
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.data, root.right);
        }

        if(value < root.data)
            root.left = delete(value, root.left);

        if(root.data < value)
            root.right = delete(value, root.right);

        return root;
    }
    int minValue(BinaryNode root) {
        int min_value = root.data;
        while (root.left != null) {
            min_value = root.left.data;
            root = root.left;
        }
        return min_value;
    }

    void inOrder(BinaryNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void preOrder(BinaryNode node){
        if(node == null)
            return;

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(BinaryNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
