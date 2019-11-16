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
        //���һ����׺���ʽתΪ��׺���ʽ
        //1+((2+3)x4)-5 --> 1 2 3 + 4 * + 5 -
        //�Ƚ���׺���ʽת��һ��ArrayList
        String expression = "1+((2+3)x4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("��׺���ʽ��Ӧ��list��"+infixExpressionList);

        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("��׺���ʽ��Ӧ��list��" + parseSuffixExpressionList);

        /*//�ȶ���һ���沨�����ʽ
        //Ϊ�˷��㣬���ֺͷ���ʹ�ÿո����
        String suffixExpression = "3 4 + 5 x 6 -";
        //1.�Ƚ���Щװ��ArrayList
        //2.��ArrayList���ݸ�һ�����������ջ��ɼ���
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("����Ľ���ǣ�" + res);*/
    }
    public static  List<String> parseSuffixExpressionList(List<String> ls){
        //��������ջ
        Stack<String> s1 = new Stack<String>();//����ջ
        //��ΪS2������ת��������û��pop���������ջ���Ҫ���򣬲���ջ�ṹ��ֱ��ʹ��List���S2
        //Stack<String> s2 = new Stack<String>();//�����м�������
        List<String> s2 = new ArrayList<>();
        //����ls
        for(String item : ls){
            if(item.matches("\\d+")){//�����һ�����֣����뵽s2
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //����������ţ������ε���s1ջ��ֱ��(
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//�������ŵ���������Ҫ������������
            }else{
                //��item����������ȼ�С�ڻ����S1ջ�������ȼ�����s1ջ���������ѹ��S2��
                // �ٴ�ת����4.1����s1���µ�ջ����������бȽ�
                //��ʱȱ��һ���Ƚ����ȼ��ߵ͵ķ���
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //����Ҫɨ�赽�������ѹ��S1
                s1.push(item);
            }
        }
        //��s1ʣ�µ�Ԫ�ؼ��뵽s2��
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;//��Ϊ�Ǵ�ŵ�list�У���˰�˳����������Ƕ�Ӧ���沨�����ʽ
    }

    //����׺���ʽת�ɶ�Ӧ��list
    public  static List<String> toInfixExpressionList(String s){
        //����һ��List�����׺���ʽ
        List<String> ls = new ArrayList<String>();
        int i = 0;//�൱��ָ�룬���ڱ�����׺���ʽ�ַ���
        String str;//�Զ�λ����ƴ�Ӳ���
        char c;//ÿ����һ���ַ�����c
        do{
            //���c��һ�������֣�����Ҫ���뵽ls��
            if(((c = s.charAt(i))< 48) || ((c = s.charAt(i)) > 57)){
                ls.add("" + c);
                i++;
            }else{
                str = "";//�Ƚ�str�ÿ�,'0' = 48; '9' = 57;
                while(i < s.length() && ((c = s.charAt(i)) >= 48) && ((c = s.charAt(i)) <= 57)){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    //��һ���沨�����ʽ�����ν����ݺ����������ArrayList��
    public static List<String> getListString(String suffixExpression){
        //��suffixExpression�ָ�
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele : split){
            list.add(ele);
        }
        return list;
    }

    //��ɶ��沨�����ʽ������
    public static int calculate(List<String> ls){
        //����ջ��һ������
        Stack<String> stack = new Stack<String>();
        for(String item : ls){
            //ʹ��������ʽȡ����
            if(item.matches("\\d+")){
                //��ջ
                stack.push(item);
            }else{
                //����Ԫ�ؽ������㣨˵���������),����ջ
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
                    throw new RuntimeException("���������");
                }
                stack.push(res + "");//������ת���ַ���
            }

        }
        //�������stack�е�������������
        return Integer.parseInt(stack.pop());
    }
}
/**
 * ��׺���ʽתΪ��׺���ʽ
 * 1.��ʼ������ջ�������ջS1�ͱ����м�����S2
 * 2.�����ң�ɨ����׺���ʽ
 * 3.����������ʱ��ѹ��S2
 * 4.�����������ʱ�����S1�еĽ��бȽϣ�
 * 4.1���S1Ϊ�ջ���Ϊ�����ţ�����ջ��
 * ������ȼ���ջ����Ҫ�ߣ���ջ��
 * �����ջ����Ҫ�ͣ���S1�������ѹ��S2�У��ٴ�ת��4.1
 * 5.��������ʱ��
 * ����������ţ�����ջ��
 * ����������ţ������ε���S1ջ�������������ѹ��S2��ֱ�����������ţ���ʱ��������һ������
 * 6.�ظ�2-5��ֱ�����ʽ�����ұ�
 * 7.��S1��ʣ��������ѹ��S2
 * 8.���ε���S2�е�Ԫ�أ����������׺���ʽ��Ӧ�ĺ�׺
 */

//����һ���࣬Operation������һ���������Ӧ�����ȼ�
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //дһ�����������ض�Ӧ���ȼ�������
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