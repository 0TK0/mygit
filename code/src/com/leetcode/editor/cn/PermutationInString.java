//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//
//
// 示例 1：
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 提示：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
// 👍 313 👎 0


package com.leetcode.editor.cn;

public class PermutationInString{
    public static void main(String[] args) {
         Solution solution = new PermutationInString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s1.length() ==0 || s2 == null || s2.length() == 0){
                return false;
            }
            if (s1.length() > s2.length()){
                return false;
            }
            boolean result = false;
            for (int i=0;i <= s2.length()-s1.length();i++){
                int cnt = 0;
                result = true;
                int[] charArray = new int[150];
                for (int j = 0;j< s1.length();j++){
                    charArray[s1.charAt(j)]++;
                }
                String sub = s2.substring(i,s1.length()+i);
                for (int k = 0;k<sub.length();k++){
                    if ((charArray[sub.charAt(k)]--) < 1){
                        result = false;
                        break;
                    }
                    cnt++;
                }
                if (cnt == s1.length()){
                    return true;
                }
            }
            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
