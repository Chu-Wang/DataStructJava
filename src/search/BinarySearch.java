package search;

/**
 * @author WangMingMing
 * @creat 2019-11-22 10:22
 * ���ֲ�ǰ�᣺����������
 * ֻ�ܲ���һ���������ظ���ֻ��������һ��
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr,0, arr.length - 1, 1);
        System.out.println("index=" + index);
    }



    /**
     *
     * @param arr ����
     * @param left ��ߵ��±�
     * @param right �ұߵ��±�
     * @param findVal Ҫ�ҵ�������
     * @return �����ҵ����±꣬û�з���-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        while(left <= right){//��left>rightʱ��û���ҵ�
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
