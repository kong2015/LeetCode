import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * Top K 或者Select K 问题都可以通过快速排序法或者优先队列方式解决。
 *      快速排序法：时间复杂度：O（n）。空间复杂度：O（1），因为是原地排序所以是空间消耗是常数。
 *      优先队列：时间复杂度：O（nlonK）对含有K个元素的优先队列（底层实现是二叉堆）入队和出队操作的时间复杂度都是logK，如果需要对N个元素都进行比较，则是nlogK.
 *                空间复杂度：O（K）由于开辟了一个含有K个元素的优先队列，所以空间复杂度是K。
 *
 *      然而优先队列有其他方面的优势：
 *      1、不需要一次性知道所有的数据（应用于游戏或者竞赛排名）。
 *      2、数据流的形式，可以实时知道当前TopK或者SelectK的元素。
 *      3、极大规模的数据不适合使用快速排序法。
 */
public class Offer_40 {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0){
//            return new int[0];
//        }
//        Random rnd = new Random();
//        SelectK(arr, 0, arr.length-1, k - 1, rnd);
//        return Arrays.copyOf(arr, k);
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

//    public int[] getLeastNumbers(int[] arr, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < k; i++){
//            pq.add(arr[i]);
//        }
//        for (int i = k; i< arr.length; i++){
//            if (!pq.isEmpty() && arr[i] < pq.peek()){
//                pq.remove();
//                pq.add(arr[i]);
//            }
//        }
//        int[] ret = new int[k];
//        for (int i = 0; i< k; i++){
//            ret[i] = pq.remove();
//        }
//        return ret;
//    }
}
