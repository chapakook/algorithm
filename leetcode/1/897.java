class Solution {
  private TreeNode dummy = new TreeNode(0);
  private TreeNode cur = dummy;

  public TreeNode increasingBST(TreeNode root) {
    inorder(root);
    return dummy.right;
  }

  private void inorder(TreeNode node) {
    if (node == null)
      return;
    inorder(node.left);
    node.left = null;
    cur.right = node;
    cur = node;
    inorder(node.right);
  }

  public class TreeNode {
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
}
