package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 22:24
 * 递归测试
 * 递归可以解决8皇后、汉诺塔、阶乘、迷宫、球和篮子
 * 快速排序、归并排序、二分查找、分治算法
 * 将用到栈来解决、代码简洁
 *
 * 方法中的局部变量是独立的、不相互影响
 * 引用类型是共享的
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int res = factorial(4);
        System.out.println(res);
    }
    public static void test(int n){
        //test(4)输出结果是n=2 n=3 n=4
        //如果System那一句加一个else,那么只输出n=2
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
