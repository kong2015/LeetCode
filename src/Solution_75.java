import java.util.Random;
/**
 * 颜色排序
 */
//    三路快速排序法
public class Solution_75 {
    public void sortColors(int[] nums) {
        quickSort3Ways(nums);
    }
    private static void quickSort3Ways(int[] arr){
        //        循环不变量：[0, zero]表示0. [zero+1,i-1]表示等于1。 [two,r]表示2.  i表示正在遍历的索引。
        int i = 0, zero = -1, two = arr.length;
        while(i < two){
            if (arr[i] == 0){
                zero++;//lt始终表示小于arr[l]的最后一个索引
                swap(arr, i , zero);
                i++;
            }else if (arr[i] == 2){
                two--;
                swap(arr, i, two);
            }
            else {
                i++;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void main(String[] args) {
//        Integer a = 1000, b = 1000;
//        Integer c = 100, d = 100;
//        System.out.println(a == b);
//        System.out.println(c == d);
//    }
}
