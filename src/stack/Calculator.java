package stack;

/**
 * @author WangMingMing
 * @creat 2019-11-16 19:59
 */
public class Calculator {
    public static void main(String[] args) {
        //根据思路，完成表达式的运算
        String expression = "30+2*6-2";
        //创建两个栈，一个是数字栈，一个是符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;//操作数
        int num2 = 0;//操作数
        int oper = 0;//操作符
        int res = 0;//结果
        char ch = ' ';//将每次扫描得到的char保存到ch中
        String keepNum = "";//用于拼接多位数
        while(true){
            //依次得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    //进行处理,如果ch优先级小于等于栈中的优先级...
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        //入栈后，把当前的操作符入符号栈
                        operStack.push(ch);
                    }else{
                        //如果当前的操作符大于栈中的操作符优先级
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);//栈为空，直接入栈
                }
            }else{//如果是数字，直接入数字栈
                //numStack.push(ch - 48);
                //当发现一个数字的时候不能立即入栈，也可能是两位数字,要多看一位
                keepNum += ch;
                //如果ch是字符串最后一位，
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //判断下一位是不是数字,如果是数字，继续扫描,如果是运算符。。。
                    if(operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))){
                        //如果是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index+1,并判断是否扫描到最后
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        while(true){
            if(operStack.isEmpty()){//如果符号栈位空，计算结束，数字栈中只有一个数字
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("表达式" + expression +"结果是：" + numStack.pop());
    }
}

//先创建一个栈，直接使用前面创建好的数组栈
//需要扩展功能
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，数据放在这里
    private int top = -1;//初始为-1，表示没有数据
    public ArrayStack2(int maxSize){
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

    //返回运算符的优先级，使用数字表示，数字越大，优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        if(oper == '+' || oper == '-') {
            return 0;
        }else{
            return -1;//假定只有+ - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //增加一个方法可以返回当前栈顶的元素，但是不是真正的pop
    public int peek(){
        return stack[top];
    }
    //计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0;//用于存放计算的结果
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
