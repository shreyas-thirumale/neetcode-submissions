# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = deque()
        arr = []
        if root is None:
            return arr
        q.append(root)
        while len(q) > 0:
            size = len(q)
            templist = []
            for i in range(size):
                temp = q.popleft()
                templist.append(temp.val)
                if temp.left is not None:
                    q.append(temp.left)
                if temp.right is not None:
                    q.append(temp.right)
            arr.append(templist)
        return arr
        