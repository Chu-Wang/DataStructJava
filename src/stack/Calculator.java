package stack;

/**
 * @author WangMingMing
 * @creat 2019-11-16 19:59
 */
public class Calculator {
    public static void main(String[] args) {
        //����˼·����ɱ��ʽ������
        String expression = "30+2*6-2";
        //��������ջ��һ��������ջ��һ���Ƿ���ջ
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;//������
        int num2 = 0;//������
        int oper = 0;//������
        int res = 0;//���
        char ch = ' ';//��ÿ��ɨ��õ���char���浽ch��
        String keepNum = "";//����ƴ�Ӷ�λ��
        while(true){
            //���εõ�expression�е�ÿһ���ַ�
            ch = expression.substring(index, index + 1).charAt(0);
            //�ж�ch
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    //���д���,���ch���ȼ�С�ڵ���ջ�е����ȼ�...
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        //��ջ�󣬰ѵ�ǰ�Ĳ����������ջ
                        operStack.push(ch);
                    }else{
                        //�����ǰ�Ĳ���������ջ�еĲ��������ȼ�
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);//ջΪ�գ�ֱ����ջ
                }
            }else{//��������֣�ֱ��������ջ
                //numStack.push(ch - 48);
                //������һ�����ֵ�ʱ����������ջ��Ҳ��������λ����,Ҫ�࿴һλ
                keepNum += ch;
                //���ch���ַ������һλ��
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //�ж���һλ�ǲ�������,��������֣�����ɨ��,����������������
                    if(operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))){
                        //����������������ջ
                        numStack.push(Integer.parseInt(keepNum));
                        //��keepNum���
                        keepNum = "";
                    }
                }
            }
            //��index+1,���ж��Ƿ�ɨ�赽���
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        while(true){
            if(operStack.isEmpty()){//�������ջλ�գ��������������ջ��ֻ��һ������
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("���ʽ" + expression +"����ǣ�" + numStack.pop());
    }
}

//�ȴ���һ��ջ��ֱ��ʹ��ǰ�洴���õ�����ջ
//��Ҫ��չ����
class ArrayStack2{
    private int maxSize;//ջ�Ĵ�С
    private int[] stack;//����ģ��ջ�����ݷ�������
    private int top = -1;//��ʼΪ-1����ʾû������
    public ArrayStack2(int maxSize){
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

    //��������������ȼ���ʹ�����ֱ�ʾ������Խ�����ȼ�Խ��
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        if(oper == '+' || oper == '-') {
            return 0;
        }else{
            return -1;//�ٶ�ֻ��+ - * /
        }
    }

    //�ж��ǲ���һ�������
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //����һ���������Է��ص�ǰջ����Ԫ�أ����ǲ���������pop
    public int peek(){
        return stack[top];
    }
    //���㷽��
    public int cal(int num1, int num2, int oper){
        int res = 0;//���ڴ�ż���Ľ��
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//ע��˳��
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
