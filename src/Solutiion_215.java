import java.util.Random;
import java.util.PriorityQueue;
/**
 * 第K个最大的数
 */
public class Solutiion_215 {
    //    双路快速排序法
//    public int findKthLargest(int[] nums, int k) {
//        Random rnd = new Random();
//        return SelectK(nums, 0, nums.length-1, nums.length - k, rnd);
//    }
//    private static int SelectK(int[] arr, int l, int r, int k, Random rnd){
//        int p = partition2Ways(arr,l, r, rnd);
//        if (p == k){
//            return arr[p];
//        }else if (p <= k){
//            return SelectK(arr,p+1, r, k, rnd);
//        }else {
//            return SelectK(arr, l, p-1, k, rnd);
//        }
//    }
//    private static int partition2Ways(int[] arr, int l, int r, Random rnd){
//        int randomIndex = l + rnd.nextInt(r - l + 1);
//        swap(arr, randomIndex, l);
////        循环不变量：[l+1, i-1]表示小于等于arr[l].  [j+1, r]表示大于等于arr[l].
//        int i = l + 1, j = r;
//        while(true){
//            while (i <= j && arr[i] < arr[l]){
//                i++;
//            }
//            while(i <= j && arr[j] > arr[l]){
//                j--;
//            }
//            if (i >= j){
//                break;
//            }
//            swap(arr, i ,j);
//            i++;
//            j--;
//        }
//        swap(arr, l , j);
//        return j;
//    }
//    private static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++){
            if (!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
