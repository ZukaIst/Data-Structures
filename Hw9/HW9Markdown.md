# HW9 Approaches
Steps to solution
- Create a tree
- compare p and q to root
- use recursion
- if not root or not p or not q, return root
- if p and q are on the same side of the tree, call the function on that subtree
- if p and q are not on the same side of the tree, then return the root that we considered as current
- to iterate: look through the tree values one after the other
