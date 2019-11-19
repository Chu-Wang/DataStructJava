package dac;

/**
 * @author WangMingMing
 * @creat 2019-11-19 16:18
 * 分治算法
 * 汉诺塔问题
 *
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5, 'A', 'B', 'C');
    }
    //汉诺塔的移动方法
    //使用分治算法
    public static void hanoitower(int num, char a, char b, char c){
        //如果只有一个盘子
        if(num == 1){
            System.out.println("第 1 个盘从 "+ a + "->" + c);
        }else{
            //如果n>=2,分两部分，最上面的n-1个盘子，和最下面的第n个盘子
            //先把最上面的盘子A->B
            //再把最下面的盘子从A->C
            //再将n-1个盘子从B->C
            hanoitower(num - 1, a, c, b);
            System.out.println("第 " + num + " 个盘从 " + a + "->" + c);
            hanoitower(num - 1, b, a, c);
        }
    }
}
