/**
 * 二分查找法
 * 非递归实现和递归实现
 */
public class Solution_704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int searchR(int[] data, int target) {
        return searchR(data,  target, 0, data.length-1);
    }

    public static int searchR(int[] data, int target, int l, int r) {
        if (l > r){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (data[mid] == target){
            return mid;
        }else if (data[mid] < target){
            return searchR(data, target, mid + 1, r);
        }
        else{
            return searchR(data, target, l, mid - 1);
        }
    }

}
