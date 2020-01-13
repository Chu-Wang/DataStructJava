package sort;

import java.util.Arrays;

/**
 * @author WangMingMing
 * @creat 2020-01-13 14:15
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        //先写合并方法
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后" + Arrays.toString(arr));
    }

    //分
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;//中间索引
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     *
     * @param arr  排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;//初始化，左边有序序列的初始索引
        int j = mid + 1;//初始化，右边有序序列的初始索引
        int t = 0;//中转数组的初始索引
        //(1)
        //先把左右两边有序数据按照规则填充到temp数组
        //直到左右两边有一方处理完毕为止
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
        //把有剩余数据的一方依次填充到temp中
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
        //将temp数组的元素拷贝到array
        //并不是每一次都要拷贝
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }


}
