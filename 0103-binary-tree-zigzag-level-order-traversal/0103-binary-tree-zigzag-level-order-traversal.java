/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean isRight = false;
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode == null){
                list.add(new ArrayList<>(ls));
                ls.clear();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
                isRight = !isRight;
            }
            else{
                if(isRight){
                    ls.addLast(currNode.val);
                }
                else{
                    ls.addFirst(currNode.val);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
            }
        }
        return list;
    }
}