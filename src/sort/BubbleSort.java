package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 17:00
 * ð������
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1, 1000, 985, 23, 210};
        System.out.println("����ǰ�����飺"+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("���������飺"+ Arrays.toString(arr));
        //Ϊ�˲���ð�������ʱ�临�Ӷȣ��������80000�����ݣ�����
        int[] array = new int[80000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        //long a = System.currentTimeMillis();
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date1);
        System.out.println("����ǰ��ʱ���ǣ�" + date1Str);

        bubbleSort(array);
        //System.out.println(Arrays.toString(array));
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("������ʱ���ǣ�" + date2Str);

    }
    //ð�����򷽷�
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;//��ʾ�Ƿ���й�����
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(flag == false){//��ʾû�з���������������ֱ��break��
                break;
            }else{
                flag = false;//Ϊ�˽�����һ�ε���ѭ���ж�
            }
        }

    }

}
