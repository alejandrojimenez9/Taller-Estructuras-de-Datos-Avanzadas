class Solution{
    public boolean isBST(TreeNode root, long low, long high)
    {
        if (root==null) return true;
        
        if (root.val <= low || root.val >= high) return false;

        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root)
    {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
