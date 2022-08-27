public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {
        val = 0;
        left = right = null;
    }

    public TreeNode(int _val) {
        this.val = _val;
    }

    public TreeNode(int _val, TreeNode left, TreeNode right) {
        this.val = _val;
        this.left = left;
        this.right = right;
    }
}
