package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 22:48
 * 回溯法解决迷宫
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];//迷宫八行七列
        //使用1表示墙；
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;//上下两行为墙
        }
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;//左右两列为墙
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        //输出新的地图
        System.out.println("走过后");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    //使用递归回溯为小球找路

    /**
     *
     * @param map 表示地图，当值为0没有走过，当为1为墙，当为2表示通路，可以走；3表示走过，走不通
     * @param i 从哪个位置开始找，出发（1，1），到达（6，5）
     * @param j
     * @return 如果找到路，就返回true,否则返回false
     */
    //需要顶一个策略，先下，再右、再上、再左；如果该点走不通，再回溯
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            //说明通路已经找到，直接return true
            return true;
        }else{
            if(map[i][j] == 0){//当前该节点没有走过
                //按照策略走
                map[i][j] = 2;//假定该点可以走通
                if(setWay(map, i + 1, j)){//向下走
                    return true;
                }else if(setWay(map, i, j + 1)){//向右走
                    return true;
                }else if(setWay(map, i - 1, j)){//向上走
                    return true;
                }else if(setWay(map, i, j - 1)){//向左走
                    return true;
                }else{//说明该点走了一圈是死路，置为3
                    map[i][j] = 3;
                    return false;
                }
            }else{//如果map[i][j] != 0 可能是1、2、3
                return false;
            }
        }
    }
}
