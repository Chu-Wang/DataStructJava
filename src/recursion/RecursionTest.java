package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 22:24
 * �ݹ����
 * �ݹ���Խ��8�ʺ󡢺�ŵ�����׳ˡ��Թ����������
 * �������򡢹鲢���򡢶��ֲ��ҡ������㷨
 * ���õ�ջ�������������
 *
 * �����еľֲ������Ƕ����ġ����໥Ӱ��
 * ���������ǹ����
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int res = factorial(4);
        System.out.println(res);
    }
    public static void test(int n){
        //test(4)��������n=2 n=3 n=4
        //���System��һ���һ��else,��ôֻ���n=2
        if(n > 2){
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return factorial(n - 1) * n;
        }
    }
}
