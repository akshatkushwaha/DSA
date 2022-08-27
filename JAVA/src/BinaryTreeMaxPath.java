public class BinaryTreeMaxPath {
    //    Max path from leaf to leaf
    static class Solution {
        int answer = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return answer;
        }

        private int helper(TreeNode root) {
            if (root == null)
                return 0;

            int maxPathSumLeft = helper(root.left);
            int maxPathSumRight = helper(root.right);

            answer = Math.max(answer, maxPathSumLeft + root.val + maxPathSumRight);

            return Math.max(root.val + maxPathSumLeft, root.val + maxPathSumRight);
        }
    }

    public static void main(String[] args) {
        Temp.Solution solution = new Temp.Solution();
        TreeNode root = new TreeNode(-3);
        System.out.println(solution.maxPathSum(root));
    }
}
