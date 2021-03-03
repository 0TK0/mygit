import java.util.Stack;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 8:38 下午 2021/2/24
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '{' || c == '[' || c == '('){
                stack.add(c);
                continue;
            }
            if (c == '}'){
                if (stack.pop() != '{'){
                    return false;
                }
            }
            if (c == ']'){
                if (stack.pop() != '['){
                    return false;
                }
            }
            if (c == ')'){
                if (stack.pop() != '('){
                    return false;
                }
            }
        }

        return true;

    }
}
