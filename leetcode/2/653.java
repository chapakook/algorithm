import java.util.*;

class Solution {
  public boolean findTarget_1(TreeNode root, int k) {
    Set<Integer> seen = new HashSet<>();
    return dfs(root, k, seen);
  }

  private boolean dfs(TreeNode node, int target, Set<Integer> seen) {
    if (node == null)
      return false;
    int need = target - node.val;
    if (seen.contains(need))
      return true;
    return dfs(node.left, target, seen) || dfs(node.right, target, seen);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
