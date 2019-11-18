package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 17:35
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        //有n-1轮排序、每一轮排序都是大循环
        //虽然和冒泡排序都是O(N^2)，但是选择排序比冒泡要快
        int[] arr = {101, 34, 119, 1, 1000, 985, 23, 210};
        int[] array = new int[80000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        /*System.out.println("排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));*/
        //Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(new Date());
        System.out.println("排序前的时间是：" + date1Str);
        selectSort(arr);
        String date2Str = sdf.format(new Date());
        System.out.println("排序后的时间是：" + date2Str);
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){//说明假定的最小值并不是最小值、重置最小值
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
