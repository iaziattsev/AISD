package QueueStack;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        String opening="({[";
        String closing="]})";
        int n=s.length();

        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(opening.indexOf(ch)!=-1){
                st.push(ch);
            }
            else{
                if(st.size()==0){
                    return false;
                }
                char tmp=st.pop();
                if(tmp!=getVal(ch)){
                    return false;
                }
            }
        }
        return st.size()==0;
    }

    public char getVal(char ch){
        switch(ch){
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default: return ' ';
        }
    }
}
