import java.util.Arrays;

public class ConstructBT {
    public static void main(String[] args) {

    }

    public static TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder){
        if(preorder.length == 0)
            return null;

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

        System.arraycopy(inorder, 0, leftInorder, 0, position);
        System.arraycopy(inorder, position + 1, rightInorder, 0, rightInorder.length);
        System.arraycopy(preorder, 1, leftPreorder, 0, position);
        System.arraycopy(preorder, position + 1, rightPreorder, 0, rightPreorder.length);

        System.out.println(Arrays.toString(leftPreorder));
        System.out.println(Arrays.toString(leftInorder));
        System.out.println(Arrays.toString(rightPreorder));
        System.out.println(Arrays.toString(rightInorder));

        root.left = buildTreePreorderInorder(leftPreorder, leftInorder);
        root.right = buildTreePreorderInorder(rightPreorder, rightInorder);

        return root;
    }

    public static TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder){
        TreeNode root = new TreeNode();

        return root;
    }
}
