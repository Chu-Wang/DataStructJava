package sort;

import java.util.Arrays;

/**
 * @author WangMingMing
 * @creat 2019-11-18 16:25
 * ��������
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, 1000, 985, 23, 210};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        //ʹ�����Ƶ��ķ�ʽ
        //��һ��{101��34��119��1} => {34, 101, 119, 1}
        //��������������
        for(int i = 1; i < arr.length; i++){
            int insertVal = arr[i];//������������
            int insertIndex = i - 1;//Ѱ�Ҵ�������±�
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                //��֤�������λ�ò�Խ�硢����������ֱ�insertIndex�ϵ�ֵҪС�������Ϳ��Խ�ԭ�ȵ�ֵ����
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //�˳�ѭ��ʱ������λ���ҵ�,����λ��λinsertIndex + 1
            arr[insertIndex + 1] = insertVal;
            System.out.println("�� " + i + " �ֲ���");
            System.out.println(Arrays.toString(arr));

        }

    }
}
