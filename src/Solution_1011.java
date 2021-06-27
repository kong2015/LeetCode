import java.util.Arrays;

public class Solution_1011 {
    public  int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r){
            int mid = l + (r- l) / 2;
            int days = shipDays(weights, mid);
            if (days > D){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
    private int shipDays(int[] weights, int load){
        int curLoad = 0;
        int days = 0;
        for (int weight: weights){
            if (curLoad + weight <= load){
                curLoad += weight;
            }else {
                days++;
                curLoad = weight;
            }
        }
        days++;
        return days;
    }

//    private int shipDays(int[] weights, int load){
//        int days = 0;
//        int i = 0;
//        while (i < weights.length){
//            int res = 0;
//            while (i < weights.length){
//                res += weights[i];
//                if (res <= load){
//                    i++;
//                }else break;
//            }
//            days++;
//        }
//        return days;
//    }
}
