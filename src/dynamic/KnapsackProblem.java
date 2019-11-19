package dynamic;

/**
 * @author WangMingMing
 * @creat 2019-11-19 16:31
 * ��̬�滮
 * ��������
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//��Ʒ������
        int[] val = {1500, 3000, 2000};//��Ʒ�ļ�ֵ
        int m = 4;//����������
        int n = val.length;//��ʾ��Ʒ�ĸ���
        //Ϊ�˼�¼������Ʒ����������Ƕ���һ����ά����
        int[][] path = new int[n + 1][m + 1];
        int[][] v = new int[n + 1][m + 1];//��¼������ֵ

        //��ʼ����һ�е�һ��
        for(int i = 0; i < v.length; i++){
            v[i][0] = 0;//�ѵ�һ������Ϊ0
        }
        for(int i = 0; i < v[0].length; i++){
            v[0][i] = 0;//�ѵ�һ������Ϊ0
        }
        //���ݹ�ʽ����̬�滮
        for(int i = 1; i < v.length; i++){//�������һ��
            for(int j = 1; j < v[i].length; j++){//�������һ��
                if(w[i - 1] > j){//������i��1��ʼ������Ҫ�����޸�
                    v[i][j] = v[i - 1][j];
                }else{
                    //��Ϊ���ǵ�i�Ǵ�1��ʼ�ӵġ���˹�ʽ��Ҫ����
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //Ϊ���ܹ��õ���ô����ģ�����ʹ���������������
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]){
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //���һ��v���������
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //��һ������ô�����
        //����path
        /*for(int i = 0; i < path.length; i++){
            for(int j = 0; j < path[i].length; j++){
                if(path[i][j] == 1)
                    System.out.printf("��%d����Ʒ���뱳��\n", i);
            }
        }*/
        int i = path.length - 1;//�е�����±�
        int j = path[0].length - 1;//�е�����±�
        while(i > 0  && j > 0){//��path��������ʼ��
            if(path[i][j] == 1){
                System.out.printf("��%d����Ʒ���뱳��\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
