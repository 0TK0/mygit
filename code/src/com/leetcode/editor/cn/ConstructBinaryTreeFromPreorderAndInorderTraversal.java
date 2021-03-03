////根据一棵树的前序遍历与中序遍历构造二叉树。
////
//// 注意:
////你可以假设树中没有重复的元素。
////
//// 例如，给出
////
//// 前序遍历 preorder = [3,9,20,15,7]
////中序遍历 inorder = [9,3,15,20,7]
////
//// 返回如下的二叉树：
////
////     3
////   / \
////  9  20
////    /  \
////   15   7
//// Related Topics 树 深度优先搜索 数组
//// 👍 896 👎 0
//
//
//package com.leetcode.editor.cn;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
//    public static void main(String[] args) {
//         Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
//    }
//    //leetcode submit region begin(Prohibit modification and deletion)
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0;i<inorder.length;i++){
//            map.put(inorder[i],i);
//        }
//        return recover(preorder,0,preorder.length,inorder,0,inorder.length,map);
//    }
//
//    private TreeNode recover(int[] preorder,int p_left,int p_right,int[] inorder,int i_left,int i_right,Map<Integer,Integer> map){
//        if (p_left == p_right){
//            return null;
//        }
//        int rootVal = preorder[p_left];
//
//        TreeNode root = new TreeNode(rootVal);
//        int i_index = map.get(rootVal);
//        int i_index_num = i_index-i_left;
//        root.left = recover(preorder,p_left+1,p_left+i_index_num+1,inorder,i_left,i_index,map);
//        root.right = recover(preorder,p_left+i_index_num+1,p_right,inorder,i_index+1,i_right,map);
//        return root;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
