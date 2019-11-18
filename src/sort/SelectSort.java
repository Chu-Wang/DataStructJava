package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 17:35
 * ѡ������
 */
public class SelectSort {
    public static void main(String[] args) {
        //��n-1������ÿһ�������Ǵ�ѭ��
        //��Ȼ��ð��������O(N^2)������ѡ�������ð��Ҫ��
        int[] arr = {101, 34, 119, 1, 1000, 985, 23, 210};
        int[] array = new int[80000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        /*System.out.println("����ǰ��" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("�����" + Arrays.toString(arr));*/
        //Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(new Date());
        System.out.println("����ǰ��ʱ���ǣ�" + date1Str);
        selectSort(arr);
        String date2Str = sdf.format(new Date());
        System.out.println("������ʱ���ǣ�" + date2Str);
    }

    //ѡ������
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){//˵���ٶ�����Сֵ��������Сֵ��������Сֵ
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != 0){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
