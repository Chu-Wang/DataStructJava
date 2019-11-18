package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 18:25
 * ϣ������
 * ϣ�������ǸĽ��汾�Ĳ������򣨲��������м�������������Ϊ��������������ôÿ�ζ�Ҫ�Ƚ�ȫ����Ԫ�أ�
 * ��������顢�Է���ֱ�ӽ�������
 * ����������λ��
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSortNew(arr);
        System.out.println(Arrays.toString(arr));
        //���Դ������ݺ�ʱ
        int[] array = new int[800000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(new Date());
        System.out.println("����ǰ��ʱ���ǣ�" + date1Str);
        shellSortNew(array);
        String date2Str = sdf.format(new Date());
        System.out.println("������ʱ���ǣ�" + date2Str);
    }

    public static void shellSort(int[] arr){
        //ϣ�����򡢶��������в���ʱ����ý��������������ƶ���
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                //���������е�Ԫ�ء���gap�顢ÿ���ж��ٸ�Ԫ�ء�����gap
                for(int j = i - gap; j >= 0; j -= gap){//������
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSortNew(int[] arr){
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            //�ӵ�gap��Ԫ�ؿ�ʼ����������ڵ������ֱ�Ӳ�������
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];

                while(j - gap >= 0 && temp < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    //��j����gap����--
                    j -= gap;
                }
                //���˳�whileѭ����˵���ҵ��˲����λ��
                arr[j] = temp;

            }
        }
    }
}

