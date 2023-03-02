import java.util.Objects;

public class BuildBinaryTree {
    public static TreeNode buildBinaryTree(String[] treeArray, int index) {
        TreeNode node = null;
        if (index < treeArray.length) {
            String value = treeArray[index];
            if (!Objects.equals(value, "null")) {
                node = new TreeNode(Integer.parseInt(value));
                node.left = buildBinaryTree(treeArray, (2 * index) + 1);
                node.right = buildBinaryTree(treeArray, (2 * index) + 2);
            }
        }
        return node;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void printPreorder(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
}
