package recursion;

/**
 * @author WangMingMing
 * @creat 2019-11-18 23:39
 * �˻ʺ�����
 *
 */
public class Queue8 {
    //�ȶ���һ��max,��ʾ���ж��ٸ��ʺ�
    int max = 8;
    //��������array,����ʺ�λ�ô�ŵĽ��,����arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        //���԰˻ʺ�����
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.print("һ���У�" + count);
    }

    //���ʺ�ڷŵ�λ�ñ�������
    private void print(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        count++;
    }

    //��дһ�����������õ�n���ʺ�
    private void check(int n){
        if(n == max){//n==8���൱���ڷŵھŸ��ʺ����Կ���ͣ�ˣ�8���ʺ�ź���
            print();
            return ;
        }
        //���η���ʺ󣬲��ж��Ƿ��ͻ
        for(int i = 0; i < max; i++){
            //�Ȱѵ�ǰ�Ļʺ�ŵ����еĵ�1�С��ڶ��С�����������
            array[n] = i;
            //�жϷ��õ�n���ʺ󵽵�n��ʱ�Ƿ��ͻ
            if(judge(n)){
                //˵������ͻ,���ŷ�n+1���ʺ�,����ʼ�ݹ�
                check(n+1);
            }
            //�����ͻ���᷵��,�൱����Χforѭ��i++;�൱�ڰѵ�n���ʺ���ڸ���i+1��
        }
    }

    //�鿴�����Ƿ��õ�n���ʺ�ʱ��ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
    public boolean judge(int n){//�˴�n��ʾ��n���ʺ�
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                //�ֱ��ǲ�����ͬһ�С���ʾ�ж��Ƿ���ͬһб��
                //�����ж�ͬһ�У���Ϊһά���飬�������ͬһ��
                return false;
            }
        }
        return true;
    }
}
