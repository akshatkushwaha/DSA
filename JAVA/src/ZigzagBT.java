import java.util.*;
import java.util.LinkedList;

public class ZigzagBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9, new TreeNode(10), new TreeNode(12)),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int depth = -1;

        while (!queue.isEmpty()) {
            depth += 1;
            if (result.size() <= depth)
                result.add(new ArrayList<>());

            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode head = queue.poll();
                assert head != null;
                result.get(depth).add(head.val);
                if (head.left != null)
                    queue.add(head.left);
                if (head.right != null)
                    queue.add(head.right);
            }

        }

        for(int i = 0; i < result.size(); ++i){
            if(i % 2 == 1)
                Collections.reverse(result.get(i));
        }

        return result;
    }
}
