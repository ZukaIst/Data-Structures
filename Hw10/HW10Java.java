import java.util.*;

public class HW10Java {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return null;
        }

        List<List<Integer>> listing = new ArrayList<>();

        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()){
            int size = queue.size();

            List<Integer> listing2 = new ArrayList<>();
            for (int i=0; i<size;i++){
                TreeNode tempNode = queue.remove();
                listing2.add(tempNode.val);

                if (tempNode.left!=null){
                    queue.add (tempNode.left);
                }

                if (tempNode.right!=null){
                    queue.add (tempNode.right);
                }
            }
            listing.add(listing2);
        }
        return listing;
    }
}
