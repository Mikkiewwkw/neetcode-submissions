/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class TreeNodeWithLevel {
        public TreeNode node;
        public int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> nextLevelNodes = new LinkedList<>();
        Queue<TreeNodeWithLevel> queue = new ArrayDeque<>();

        if (root != null) queue.offer(new TreeNodeWithLevel(root, 1));
        while (queue.size() != 0) {
            TreeNodeWithLevel node = queue.poll();
            if (result.size() < node.level) {
                result.add(new LinkedList(List.of(node.node.val)));
            } else {
                List<Integer> levelList = result.get(node.level - 1);
                levelList.add(node.node.val);
            }
            
            if (node.node.left != null)
                queue.offer(new TreeNodeWithLevel(node.node.left, node.level + 1));
            if (node.node.right != null)
                queue.offer(new TreeNodeWithLevel(node.node.right, node.level + 1));
        }

        return result;
    }
}
