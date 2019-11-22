package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangMingMing
 * @creat 2019-11-22 10:39
 * ���ֲ���
 * �����ظ����ֳ��ֵ�λ�ã����һ����������װ�±�
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
            //���ҵ����Ȳ�Ҫ����
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;
            while(true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }
                //����Ž���
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);//�м��mid������
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
