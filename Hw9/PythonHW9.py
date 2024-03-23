class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def lowestCommonAncestor(root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    if not root or not p or not q:
        return root

    if root.val > p.val and root.val > q.val:
        return lowestCommonAncestor(root.left, p, q)
    if root.val < p.val and root.val < q.val:
        return lowestCommonAncestor(root.right, p, q)

    return root

# make the binary search tree
root = TreeNode(4)
three = root.left = TreeNode(3)
eight = root.right = TreeNode(8)
one = three.left = TreeNode(1)
five = eight.left = TreeNode(5)
nine = eight.right = TreeNode(9)

# Test cases
lca1 = lowestCommonAncestor( root, one, nine)
print("LCA of 1 and 9:", lca1.val)  # Expected output: 4

lca2 = lowestCommonAncestor(root, five, nine)
print("LCA of 5 and 9:", lca2.val)  # Expected output: 8

lca3 = lowestCommonAncestor(root, three, one)
print("LCA of 3 and 1:", lca3.val)  # Expected output: 3

lca4 = lowestCommonAncestor(root, one, five)
print("LCA of 1 and 5:", lca4.val)  # Expected output: 4