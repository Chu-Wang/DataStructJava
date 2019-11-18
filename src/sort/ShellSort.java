package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 18:25
 * 希尔排序
 * 希尔排序是改进版本的插入排序（插入排序有极端情况、如果因为是逆序的情况，那么每次都要比较全部的元素）
 * 将数组分组、对分组直接进行排序
 * 交换法、移位法
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSortNew(arr);
        System.out.println(Arrays.toString(arr));
        //测试大量数据耗时
        int[] array = new int[800000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(new Date());
        System.out.println("排序前的时间是：" + date1Str);
        shellSortNew(array);
        String date2Str = sdf.format(new Date());
        System.out.println("排序后的时间是：" + date2Str);
    }

    public static void shellSort(int[] arr){
        //希尔排序、对有序序列插入时会采用交换法（慢）、移动法
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                //遍历各组中的元素、共gap组、每组有多少个元素、步长gap
                for(int j = i - gap; j >= 0; j -= gap){//交换法
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
            //从第gap个元素开始逐个对其所在的组进行直接插入排序
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];

                while(j - gap >= 0 && temp < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    //把j按照gap进行--
                    j -= gap;
                }
                //当退出while循环后说明找到了插入的位置
                arr[j] = temp;

            }
        }
    }
}

