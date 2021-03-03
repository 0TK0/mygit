//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1472 👎 0


package com.leetcode.editor.cn;

public class LongestCommonPrefix{
    public static void main(String[] args) {
         Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0){
                return "";
            }
            if (strs.length == 1){
                return strs[0];
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int index = 0;
            Character target = null;
            while (true){
                String s = strs[i];
                if (index >= s.length()){
                    break;
                }
                if (i == 0){
                    target = s.charAt(index);
                    i++;
                    continue;
                }
                if (i < strs.length-1){
                    if (s.charAt(index) == target){
                        i++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (i == strs.length-1){
                    if (s.charAt(index) == target){
                        sb.append(s.charAt(index));
                        i = 0;
                        index++;
                    }else {
                        break;
                    }
                }
            }
            return sb.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
