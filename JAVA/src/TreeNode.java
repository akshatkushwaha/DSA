public class TreeNode {
    public int key;
    public TreeNode left, right;

    public TreeNode(){
        key = 0;
        left = right = null;
    }

    public TreeNode(int _key){
        this.key = _key;
    }

    public TreeNode(int _key, TreeNode left, TreeNode right){
        this.key = _key;
        this.left = left;
        this.right = right;
    }
}
