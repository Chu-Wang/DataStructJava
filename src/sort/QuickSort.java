package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 20:58
 * 冒泡排序
 * 先找一个数，把数据分成两部分，其中一部分比另一部分的值都要小、整个过程可以递归进行
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
        System.out.println("排序前的时间是：" + date1Str);
        quickSort(array, 0, array.length - 1);
        String date2Str = sdf.format(new Date());
        System.out.println("排序后的时间是：" + date2Str);
    }

    //快速排序代码实现
    public static void quickSort(int[] arr, int left, int right){
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中轴值
        int temp = 0;//临时变量
        //int pivot = arr[left + (right - left) / 2];
        while(l < r){//目的是让比pivot小的放到他的左边，比他大的放右边
            //在pivot左边一直找，找到大于等于pivot的值
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){//说明pivot左右两边的值已经按照左边全部小于等于pivot
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换之后发现arr[l] == pivot,这时让r--
            if(arr[l] == pivot){
                r--;
            }
            //如果交换之后发现arr[r] == pivot,这时让l++
            if(arr[r] == pivot){
                l++;
            }
        }
        if(l == r){
            r--;
            l++;
        }
        //向左递归
        if(left < r){
            quickSort(arr, left, r);
        }
        if(right > l){
            quickSort(arr, l, right);
        }

    }
}
