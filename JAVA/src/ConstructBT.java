public class ConstructBT {
    public static void main(String[] args) {

    }

    public static TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder){
        int current = preorder[0];
        TreeNode root = new TreeNode(current);

        if(preorder.length == 1)
            return root;

        int position = -1;

        for(int i = 0; i < inorder.length; ++i)
            if(inorder[i] == current)
                position = i;

        int[] leftPreorder = new int[position];
        int[] leftInorder = new int[position];
        int[] rightPreorder = new int[preorder.length - position - 1];
        int[] rightInorder = new int[preorder.length - position - 1];



        root.left = buildTreePreorderInorder(leftPreorder, leftInorder);
        root.right = buildTreePreorderInorder(rightPreorder, rightInorder);

        return root;
    }

    public static TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder){
        TreeNode root = new TreeNode();

        return root;
    }
}
