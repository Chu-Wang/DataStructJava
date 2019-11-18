package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author WangMingMing
 * @creat 2019-11-18 17:00
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1, 1000, 985, 23, 210};
        System.out.println("排序前的数组："+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
        //为了测试冒泡排序的时间复杂度，随机生成80000个数据，测试
        int[] array = new int[80000];
        for(int i = 0; i < 80000; i++){
            array[i] = (int)(Math.random() * 80000);
        }
        //long a = System.currentTimeMillis();
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        bubbleSort(array);
        //System.out.println(Arrays.toString(array));
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后的时间是：" + date2Str);

    }
    //冒泡排序方法
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;//表示是否进行过交换
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(flag == false){//表示没有发生过交换，可以直接break了
                break;
            }else{
                flag = false;//为了进行下一次的外循环判断
            }
        }

    }

}
