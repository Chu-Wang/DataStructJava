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
        //完成一个中缀表达式转为后缀表达式
        //1+((2+3)x4)-5 --> 1 2 3 + 4 * + 5 -
        //先将中缀表达式转成一个ArrayList
        String expression = "1+((2+3)x4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list："+infixExpressionList);

        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list：" + parseSuffixExpressionList);

        /*//先定义一个逆波兰表达式
        //为了方便，数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 x 6 -";
        //1.先将这些装进ArrayList
        //2.给ArrayList传递给一个方法，配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("计算的结果是：" + res);*/
    }
    public static  List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //因为S2在整个转换过程中没有pop操作，最终还需要逆序，不用栈结构，直接使用List替代S2
        //Stack<String> s2 = new Stack<String>();//保存中间运算结果
        List<String> s2 = new ArrayList<>();
        //遍历ls
        for(String item : ls){
            if(item.matches("\\d+")){//如果是一个数字，加入到s2
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号，则依次弹出s1栈顶直到(
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将左括号弹出，很重要！！！！！！
            }else{
                //当item运算符的优先级小于或等于S1栈顶的优先级，将s1栈顶的运算符压入S2，
                // 再次转到（4.1）与s1中新的栈顶运算符进行比较
                //此时缺少一个比较优先级高低的方法
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要扫描到的运算符压入S1
                s1.push(item);
            }
        }
        //将s1剩下的元素加入到s2中
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;//因为是存放到list中，因此按顺序输出，就是对应的逆波兰表达式
    }

    //将中缀表达式转成对应的list
    public  static List<String> toInfixExpressionList(String s){
        //定义一个List存放中缀表达式
        List<String> ls = new ArrayList<String>();
        int i = 0;//相当于指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接操作
        char c;//每遍历一个字符放入c
        do{
            //如果c是一个非数字，我需要加入到ls中
            if(((c = s.charAt(i))< 48) || ((c = s.charAt(i)) > 57)){
                ls.add("" + c);
                i++;
            }else{
                str = "";//先将str置空,'0' = 48; '9' = 57;
                while(i < s.length() && ((c = s.charAt(i)) >= 48) && ((c = s.charAt(i)) <= 57)){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
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
/**
 * 中缀表达式转为后缀表达式
 * 1.初始化两个栈，运算符栈S1和保存中间结果的S2
 * 2.从左到右，扫描中缀表达式
 * 3.遇到操作数时，压入S2
 * 4.遇到运算符的时候将其和S1中的进行比较，
 * 4.1如果S1为空或者为左括号，则入栈；
 * 如果优先级比栈顶的要高，入栈；
 * 如果比栈顶的要低，将S1的运算符压入S2中，再次转到4.1
 * 5.遇到括号时：
 * 如果是左括号，则入栈；
 * 如果是右括号，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号，此时将丢弃这一对括号
 * 6.重复2-5，直至表达式的最右边
 * 7.将S1中剩余的运算符压入S2
 * 8.依次弹出S2中的元素，结果就是中缀表达式对应的后缀
 */

//增加一个类，Operation，返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法，返回对应优先级的数字
    public static int getValue(String operation){
        int result = 0;
        switch(operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "x":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}