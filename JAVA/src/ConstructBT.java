import java.util.Arrays;

public class ConstructBT {
    public static void main(String[] args) {

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        TreeNode root = buildTreeInorderPostorder(inorder, postorder);
        TreeNode root2 = buildTreePreorderInorder(preorder, inorder);
        TreeNode root3 = buildTreePreorderPostorder(preorder, postorder);
    }

    public static TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int current = preorder[0];
        TreeNode root = new TreeNode(current);

        if (preorder.length == 1)
            return root;

        int position = -1;

        for (int i = 0; i < inorder.length; ++i)
            if (inorder[i] == current)
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

    public static TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;

        int current = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(current);

        if (postorder.length == 1)
            return root;

        int position = -1;

        for (int i = 0; i < inorder.length; ++i)
            if (inorder[i] == current) {
                position = i;
                break;
            }

        int[] rightPostorder = new int[postorder.length - position - 1];
        int[] rightInorder = new int[postorder.length - position - 1];
        int[] leftPostorder = new int[position];
        int[] leftInorder = new int[position];

        System.arraycopy(inorder, 0, leftInorder, 0, position);
        System.arraycopy(inorder, position + 1, rightInorder, 0, rightInorder.length);
        System.arraycopy(postorder, 0, leftPostorder, 0, position);
        System.arraycopy(postorder, position, rightPostorder, 0, rightPostorder.length);

        // System.out.println(Arrays.toString(leftPostorder));
        // System.out.println(Arrays.toString(leftInorder));
        // System.out.println(Arrays.toString(rightPostorder));
        // System.out.println(Arrays.toString(rightInorder));

        root.left = buildTreeInorderPostorder(leftInorder, leftPostorder);
        root.right = buildTreeInorderPostorder(rightInorder, rightPostorder);

        return root;
    }

    public static TreeNode buildTreePreorderPostorder(int[] preorder, int[] postorder) {
        if (preorder.length == 0)
            return null;

        int current = preorder[0];
        TreeNode root = new TreeNode(current);

        if (preorder.length == 1)
            return root;

        int position = -1;

        for (int i = 0; i < postorder.length; ++i)
            if (postorder[i] == preorder[1]) {
                position = i;
                break;
            }

        int[] leftPreorder = new int[position + 1];
        int[] leftPostorder = new int[position + 1];
        int[] rightPreorder = new int[preorder.length - position - 2];
        int[] rightPostorder = new int[preorder.length - position - 2];

        System.arraycopy(preorder, 1, leftPreorder, 0, position + 1);
        System.arraycopy(preorder, position + 2, rightPreorder, 0, rightPreorder.length);
        System.arraycopy(postorder, 0, leftPostorder, 0, position + 1);
        System.arraycopy(postorder, position + 1, rightPostorder, 0, rightPostorder.length);

        // System.out.println(Arrays.toString(leftPreorder));
        // System.out.println(Arrays.toString(leftPostorder));
        // System.out.println(Arrays.toString(rightPreorder));
        // System.out.println(Arrays.toString(rightPostorder));

        root.left = buildTreePreorderPostorder(leftPreorder, leftPostorder);
        root.right = buildTreePreorderPostorder(rightPreorder, rightPostorder);

        return root;
    }
}
