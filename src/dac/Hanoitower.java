package dac;

/**
 * @author WangMingMing
 * @creat 2019-11-19 16:18
 * �����㷨
 * ��ŵ������
 *
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5, 'A', 'B', 'C');
    }
    //��ŵ�����ƶ�����
    //ʹ�÷����㷨
    public static void hanoitower(int num, char a, char b, char c){
        //���ֻ��һ������
        if(num == 1){
            System.out.println("�� 1 ���̴� "+ a + "->" + c);
        }else{
            //���n>=2,�������֣��������n-1�����ӣ���������ĵ�n������
            //�Ȱ������������A->B
            //�ٰ�����������Ӵ�A->C
            //�ٽ�n-1�����Ӵ�B->C
            hanoitower(num - 1, a, c, b);
            System.out.println("�� " + num + " ���̴� " + a + "->" + c);
            hanoitower(num - 1, b, a, c);
        }
    }
}
