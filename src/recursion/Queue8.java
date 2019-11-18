package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 23:39
 * 八皇后问题
 *
 */
public class Queue8 {
    //先定义一个max,表示共有多少个皇后
    int max = 8;
    //定义数组array,保存皇后位置存放的结果,比如arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        //测试八皇后问题
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.print("一共有：" + count);
    }

    //将皇后摆放的位置保存下来
    private void print(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        count++;
    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if(n == max){//n==8，相当于在放第九个皇后，所以可以停了，8个皇后放好了
            print();
            return ;
        }
        //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++){
            //先把当前的皇后放到该行的第1列、第二列、、、挨个试
            array[n] = i;
            //判断放置第n个皇后到第n列时是否冲突
            if(judge(n)){
                //说明不冲突,接着放n+1个皇后,即开始递归
                check(n+1);
            }
            //如果冲突？会返回,相当于外围for循环i++;相当于把第n个皇后放在该行i+1列
        }
    }

    //查看当我们放置第n个皇后时就去检测该皇后是否和前面已经摆放的皇后冲突
    public boolean judge(int n){//此处n表示第n个皇后
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                //分别是不处于同一列、表示判断是否在同一斜线
                //不用判断同一行，因为一维数组，不会放在同一行
                return false;
            }
        }
        return true;
    }
}
