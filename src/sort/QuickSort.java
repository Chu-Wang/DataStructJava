package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 20:58
 * ð������
 * ����һ�����������ݷֳ������֣�����һ���ֱ���һ���ֵ�ֵ��ҪС���������̿��Եݹ����
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, 20, 900, 5, 5, 5, 30, 56};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] array = new int[8000000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(new Date());
        System.out.println("����ǰ��ʱ���ǣ�" + date1Str);
        quickSort(array, 0, array.length - 1);
        String date2Str = sdf.format(new Date());
        System.out.println("������ʱ���ǣ�" + date2Str);
    }

    //�����������ʵ��
    public static void quickSort(int[] arr, int left, int right){
        int l = left;//���±�
        int r = right;//���±�
        int pivot = arr[(left + right) / 2];//����ֵ
        int temp = 0;//��ʱ����
        //int pivot = arr[left + (right - left) / 2];
        while(l < r){//Ŀ�����ñ�pivotС�ķŵ�������ߣ�������ķ��ұ�
            //��pivot���һֱ�ң��ҵ����ڵ���pivot��ֵ
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){//˵��pivot�������ߵ�ֵ�Ѿ��������ȫ��С�ڵ���pivot
                break;
            }
            //����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //�������֮����arr[l] == pivot,��ʱ��r--
            if(arr[l] == pivot){
                r--;
            }
            //�������֮����arr[r] == pivot,��ʱ��l++
            if(arr[r] == pivot){
                l++;
            }
        }
        if(l == r){
            r--;
            l++;
        }
        //����ݹ�
        if(left < r){
            quickSort(arr, left, r);
        }
        if(right > l){
            quickSort(arr, l, right);
        }

    }
}
