package dynamic;

/**
 * @author WangMingMing
 * @creat 2019-11-19 16:31
 * 动态规划
 * 背包问题
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//表示物品的个数
        //为了记录放入商品的情况、我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];
        int[][] v = new int[n + 1][m + 1];//记录表格，最大值

        //初始化第一行第一列
        for(int i = 0; i < v.length; i++){
            v[i][0] = 0;//把第一列设置为0
        }
        for(int i = 0; i < v[0].length; i++){
            v[0][i] = 0;//把第一行设置为0
        }
        //根据公式来动态规划
        for(int i = 1; i < v.length; i++){//不处理第一行
            for(int j = 1; j < v[i].length; j++){//不处理第一列
                if(w[i - 1] > j){//程序中i从1开始，所以要进行修改
                    v[i][j] = v[i - 1][j];
                }else{
                    //因为我们的i是从1开始加的、因此公式需要调整
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了能够得到怎么放入的，不能使用上面那条语句了
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v，看看情况
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //看一下是怎么放入的
        //遍历path
        /*for(int i = 0; i < path.length; i++){
            for(int j = 0; j < path[i].length; j++){
                if(path[i][j] == 1)
                    System.out.printf("第%d个商品放入背包\n", i);
            }
        }*/
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while(i > 0  && j > 0){//从path数组的最后开始找
            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
