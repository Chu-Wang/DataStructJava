package stack;

import java.util.Scanner;

/**
 * @author WangMingMing
 * @creat 2019-11-16 19:11
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试栈是否正确
        //先创建一个ArrayStack对象,表示一个栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈");
            System.out.println("pop: 表示从栈中取出元素");
            System.out.println("请输入你的选择");
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
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.println("出栈的数据是: " + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了");
    }
}

//定义一个栈，用数组完成
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，数据放在这里
    private int top = -1;//初始为-1，表示没有数据
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈是否满
    public boolean isFull(){
        return (top == maxSize - 1);
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1 ;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return ;
        }
        top++;
        stack[top] = value;
    }

    //出栈,将栈顶的元素返回
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空,没有数据");
        }
        int res = stack[top];
        top--;
        return res;
    }

    //遍历栈,遍历时需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空，没有数据");
            return ;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
