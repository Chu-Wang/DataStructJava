package sort;

import java.util.Arrays;

/**
 * @author WangMingMing
 * @creat 2020-01-13 14:15
 * �鲢����
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        //��д�ϲ�����
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("�鲢�����" + Arrays.toString(arr));
    }

    //��
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;//�м�����
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //���ϲ�
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     *
     * @param arr  �����ԭʼ����
     * @param left ����������еĳ�ʼ����
     * @param mid �м�����
     * @param right �ұ��������еĳ�ʼ����
     * @param temp ��ת����
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;//��ʼ��������������еĳ�ʼ����
        int j = mid + 1;//��ʼ�����ұ��������еĳ�ʼ����
        int t = 0;//��ת����ĳ�ʼ����
        //(1)
        //�Ȱ����������������ݰ��չ�����䵽temp����
        //ֱ������������һ���������Ϊֹ
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //(2)
        //����ʣ�����ݵ�һ��������䵽temp��
        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        //(3)
        //��temp�����Ԫ�ؿ�����array
        //������ÿһ�ζ�Ҫ����
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }


}
