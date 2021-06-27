import java.util.Arrays;

public class Solution_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r){
            int mid = l + (r - l) / 2;
            int hours = eatingHour(piles, mid);
            if (hours <= h){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int eatingHour(int[] piles, int k){
        int res = 0;
        for (int pile : piles){
            res += pile / k +(pile % k == 0 ? 0:1);
        }
        return res;
    }
}
