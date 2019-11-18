package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 22:48
 * ���ݷ�����Թ�
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];//�Թ���������
        //ʹ��1��ʾǽ��
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;//��������Ϊǽ
        }
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;//��������Ϊǽ
            map[i][6] = 1;
        }
        //���õ���
        map[3][1] = 1;
        map[3][2] = 1;
        //�����ͼ
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        //����µĵ�ͼ
        System.out.println("�߹���");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    //ʹ�õݹ����ΪС����·

    /**
     *
     * @param map ��ʾ��ͼ����ֵΪ0û���߹�����Ϊ1Ϊǽ����Ϊ2��ʾͨ·�������ߣ�3��ʾ�߹����߲�ͨ
     * @param i ���ĸ�λ�ÿ�ʼ�ң�������1��1�������6��5��
     * @param j
     * @return ����ҵ�·���ͷ���true,���򷵻�false
     */
    //��Ҫ��һ�����ԣ����£����ҡ����ϡ���������õ��߲�ͨ���ٻ���
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            //˵��ͨ·�Ѿ��ҵ���ֱ��return true
            return true;
        }else{
            if(map[i][j] == 0){//��ǰ�ýڵ�û���߹�
                //���ղ�����
                map[i][j] = 2;//�ٶ��õ������ͨ
                if(setWay(map, i + 1, j)){//������
                    return true;
                }else if(setWay(map, i, j + 1)){//������
                    return true;
                }else if(setWay(map, i - 1, j)){//������
                    return true;
                }else if(setWay(map, i, j - 1)){//������
                    return true;
                }else{//˵���õ�����һȦ����·����Ϊ3
                    map[i][j] = 3;
                    return false;
                }
            }else{//���map[i][j] != 0 ������1��2��3
                return false;
            }
        }
    }
}
