////给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
////
//// 例如：
////给定二叉树 [3,9,20,null,null,15,7],
////
////
////    3
////   / \
////  9  20
////    /  \
////   15   7
////
////
//// 返回锯齿形层序遍历如下：
////
////
////[
////  [3],
////  [20,9],
////  [15,7]
////]
////
//// Related Topics 栈 树 广度优先搜索
//// 👍 399 👎 0
//
//
//package com.leetcode.editor.cn;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Stack;
//
//public class BinaryTreeZigzagLevelOrderTraversal{
//    public static void main(String[] args) {
//         Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null){
//            return result;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean l2r = false;
//        while (!queue.isEmpty()){
//            Deque<Integer> list =new LinkedList<>();
//            int size = queue.size();
//            while (size>0){
//                TreeNode node = queue.poll();
//
//                if (l2r) {
//                    list.offerFirst(node.val);
//                } else {
//                    list.offerLast(node.val);
//                }
//                if (node.left != null){
//                    queue.offer(node.left);
//                }
//                if (node.right != null){
//                    queue.offer(node.right);
//                }
//                size--;
//            }
//            l2r = !l2r;
//            result.add(new ArrayList<>(list));
//        }
//        return result;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
