package stack;

import java.util.Scanner;

/**
 * @author WangMingMing
 * @creat 2019-11-16 19:11
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //����ջ�Ƿ���ȷ
        //�ȴ���һ��ArrayStack����,��ʾһ��ջ
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show: ��ʾ��ʾջ");
            System.out.println("exit: �˳�����");
            System.out.println("push: ��ʾ������ݵ�ջ");
            System.out.println("pop: ��ʾ��ջ��ȡ��Ԫ��");
            System.out.println("���������ѡ��");
            key = scanner.next();
            switch(key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                case "push":
                    System.out.println("������һ������");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.println("��ջ��������: " + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳���");
    }
}

//����һ��ջ�����������
class ArrayStack{
    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//����ģ��ջ�����ݷ�������
    private int top = -1;//��ʼΪ-1����ʾû������
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //�ж�ջ�Ƿ���
    public boolean isFull(){
        return (top == maxSize - 1);
    }

    //�ж�ջ�Ƿ�Ϊ��
    public boolean isEmpty(){
        return top == -1 ;
    }

    //��ջ
    public void push(int value){
        if(isFull()){
            System.out.println("ջ����");
            return ;
        }
        top++;
        stack[top] = value;
    }

    //��ջ,��ջ����Ԫ�ط���
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("ջΪ��,û������");
        }
        int res = stack[top];
        top--;
        return res;
    }

    //����ջ,����ʱ��Ҫ��ջ����ʼ��ʾ����
    public void list(){
        if(isEmpty()){
            System.out.println("ջΪ�գ�û������");
            return ;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
