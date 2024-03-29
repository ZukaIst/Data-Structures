public class Lab5Java {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if ((root.right == null || root.right.val >= root.val) && (root.left == null || root.left.val <= root.val)) {
            return isValidBST(root.right) &&  isValidBST(root.left);
        }
        return false;
    }
}
