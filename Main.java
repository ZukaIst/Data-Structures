public class HW9Java{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    //your code here
        if (root==null || p==null || q==null){
            return root;
        }

        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);

        }
        return root;
    }
}
