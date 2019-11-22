package search;

/**
 * @author WangMingMing
 * @creat 2019-11-22 10:22
 * 二分查前提：该数组有序
 * 只能查找一个，如有重复，只返回其中一个
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr,0, arr.length - 1, 1);
        System.out.println("index=" + index);
    }



    /**
     *
     * @param arr 数组
     * @param left 左边的下标
     * @param right 右边的下标
     * @param findVal 要找到的数字
     * @return 返回找到的下标，没有返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        while(left <= right){//当left>right时，没有找到
            int mid = (left + right) / 2;
            if(findVal > arr[mid]){
                left = mid + 1;
            }else if(findVal < arr[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
