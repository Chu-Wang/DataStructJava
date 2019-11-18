package sort;

import java.util.Arrays;

/**
 * @author WangMingMing
 * @creat 2019-11-18 16:25
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, 1000, 985, 23, 210};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        //使用逐步推导的方式
        //第一轮{101，34，119，1} => {34, 101, 119, 1}
        //定义待插入的数字
        for(int i = 1; i < arr.length; i++){
            int insertVal = arr[i];//定义待插入的数
            int insertIndex = i - 1;//寻找待插入的下标
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                //保证待插入的位置不越界、待插入的数字比insertIndex上的值要小、这样就可以将原先的值后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环时，插入位置找到,插入位置位insertIndex + 1
            arr[insertIndex + 1] = insertVal;
            System.out.println("第 " + i + " 轮插入");
            System.out.println(Arrays.toString(arr));

        }

    }
}
