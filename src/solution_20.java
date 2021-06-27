import java.util.Stack;
/**
 * 有效的括号
 */
class solution_20 {
//    public boolean isValidA(String s){
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if (c == '[' || c == '{' || c == '('){
//                stack.push(c);
//            }
//            else {
//                if (stack.isEmpty())  //注意判空
//                    return false;
//                char topChar = stack.pop();
//                if (c == ']' && topChar != '['){
//                    return false;
//                }
//                if (c == '}' && topChar != '{'){
//                    return false;
//                }
//                if (c == ')' && topChar != '('){
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
        public boolean isValid(String s) {
            Stack<Character>stack = new Stack();
            for(int i = 0; i < s.length(); i++){
                Character c = s.charAt(i);
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character topChar = stack.pop();
                    if(topChar == '(' && c != ')'){
                        return false;
                    }
                    if(topChar == '[' && c != ']'){
                        return false;
                    }
                    if(topChar == '{' && c != '}'){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
}
