package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangMingMing
 * @creat 2019-11-22 10:39
 * 二分查找
 * 查找重复数字出现的位置，输出一个集合用来装下标
 */
public class BinarySearchTwo {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        List resIndexList = binarySearchTwo(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList= "+ resIndexList);
    }

    public static ArrayList<Integer> binarySearchTwo(int[] arr, int left, int right, int findVal){
        if(left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal > midVal){
            return binarySearchTwo(arr, mid + 1, right, findVal);
        }else if(findVal < midVal){
            return binarySearchTwo(arr, left, mid - 1, findVal);
        }else{
            //当找到后，先不要返回
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;
            while(true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }
                //否则放进来
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);//中间的mid加上来
            temp = mid + 1;
            while(true){
                if(temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
