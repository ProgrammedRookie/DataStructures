package com.zy.stack;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式实现计算器
 * @author zy
 *
 *
 * 后缀表达式
 *  从左至右扫描表达式，遇到数字时，将数组压入堆栈，遇到运算符时，弹出栈顶的两个数
 *  用运算符对它们最相应的计算，（次顶元素，和栈顶素），并将结果入栈，重复上述
 *  过程直到表达式最右端，最后运算等处值即为表达式的结果
 *
 */
public class PolanNotation {

    public static void main(String[] args) {
        //String ex = "3 4 + 5 * 6 -";
        //int cal = cal(getList(ex));
       // System.out.println(cal);
        List<String> list = infixList("1+((2+3)*4)-5");
        System.out.println(list);
    }


    public static List<String> infixList(String ex){

        List<String> list = new ArrayList<String>();
        String str;
        char c;
        int i = 0;

        do {
            // 如果是字符
            if ((c=ex.charAt(i)) <48 || (c=ex.charAt(i)) > 57 ){
                list.add(""+c);
                i++;
            }else {
                str = "";
                while (i < ex.length() && ( (c=ex.charAt(i)) >= 48 && (c=ex.charAt(i)) <= 57 ) ){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i < ex.length());


        return list;
    }

    public static List<String> getList(String ex){
        return Arrays.asList(ex.split(" "));
    }

    public static int cal(List<String> list){

        Stack<String> stack = new Stack<String>();

        for (String item:list){
            // 如果是数字入栈
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num1 - num2;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("符号异常");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
