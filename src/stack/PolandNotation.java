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
        //�ȶ���һ���沨�����ʽ
        //Ϊ�˷��㣬���ֺͷ���ʹ�ÿո����
        String suffixExpression = "3 4 + 5 x 6 -";
        //1.�Ƚ���Щװ��ArrayList
        //2.��ArrayList���ݸ�һ�����������ջ��ɼ���
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("����Ľ���ǣ�" + res);
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
