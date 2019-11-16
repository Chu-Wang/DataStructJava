package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WangMingMing
 * @creat 2019-11-16 21:31
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //为了方便，数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 x 6 -";
        //1.先将这些装进ArrayList
        //2.给ArrayList传递给一个方法，配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("计算的结果是：" + res);
    }
    //将一个逆波兰表达式，依次将数据和运算符放入ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele : split){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //创建栈，一个即可
        Stack<String> stack = new Stack<String>();
        for(String item : ls){
            //使用正则表达式取出数
            if(item.matches("\\d+")){
                //入栈
                stack.push(item);
            }else{
                //弹出元素进行运算（说明是运算符),再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num2 + num1;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("x")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");//把数字转成字符串
            }

        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
