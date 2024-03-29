class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Lab4Python:
    def invertTree(root):
        if root is None:
            return None
        # Swap the left and right children
        root.left, root.right = root.right, root.left
        # Recursively invert the children
        invertTree(root.left)
        invertTree(root.right)
        return root;