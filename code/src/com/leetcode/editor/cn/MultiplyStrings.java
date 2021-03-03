//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 574 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings{
    public static void main(String[] args) {
         Solution solution = new MultiplyStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public  String multiply(String num1, String num2) {
            if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
                return null;
            }
            if (num1.equals("0") || num2.equals("0")){
                return "0";
            }
            int len1 = num1.length()-1;
            int len2 = num2.length()-1;
            List<String> strs = new ArrayList<>();
            int maxLen = 0;
            for (int i = 0;i <= len2;i++){
                int a = num2.charAt(i) - 48;
                int jump = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = 0;j <= len1;j++){
                    int b = num1.charAt(len1-j)-48;
                    int sum = a*b+jump;
                    sb.append(sum%10);
                    jump = sum/10;
                }
                if (jump > 0){
                    sb.append(jump);
                }
                StringBuilder stringBuilder = reverseStr(sb.toString());
                stringBuilder.append(addZero(len2-i));
                strs.add(stringBuilder.toString());
                maxLen = Math.max(maxLen, stringBuilder.length());
            }
            StringBuilder sb = new StringBuilder();
            int jump = 0;
            for (int i = 0; i < maxLen;i++){
                int sum = 0;
                for (String s :  strs){
                    int n = s.length()-1;
                    if (i <= n){
                        sum += s.charAt(n-i)-48;
                    }
                }
                sum +=jump;
                sb.append(sum%10);
                jump = sum/10;
            }
            if (jump > 0){
                sb.append(jump);
            }

            return reverseStr(sb.toString()).toString();

        }

        private  StringBuilder reverseStr(String sb){
            StringBuilder stringBuilder = new StringBuilder();
            int len = sb.length()-1;
            for (int i=0;i <= len;i++){
                stringBuilder.append(sb.charAt(len-i));
            }
            return stringBuilder;
        }

        private  String addZero(int n){
            StringBuilder sb = new StringBuilder();
            while (n > 0){
                sb.append("0");
                n--;
            }
            return sb.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
