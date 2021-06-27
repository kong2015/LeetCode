import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
public class Offer_56 {
    public static int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums){
            n ^= num;
        }
        int m = 1;
        while ((n & m) == 0){
            m <<= 1;
        }
        int x = 0, y = 0;
        for (int num : nums){
            if ((num & m) == 0){
                x ^= num;
            }else {
                y ^= num;
            }
        }
        return new int[] {x,y};
    }

    public static int singleNumber(int[] nums) {
        int[] count = new int[4];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < 4; j++){
                count[j] += (nums[i] & 1);
                nums[i] >>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 4; i++) {
            res <<= 1;
            res |= count[3 - i] % m;
        }
        return res;
    }

    public static int countDigitOne(int n) {
        return f(n);
    }
    private static int f(int n ) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = Integer.parseInt(s.charAt(0)+"");
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            return f(pow-1) + last + 1 + f(last);
        } else {
            return pow + high*f(pow-1) + f(last);
        }
    }

    List<String> res = new LinkedList<>();
    char[] c;
    public  String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Offer_56 obj = new Offer_56();
        String[] ress = obj.permutation("abc");
        for (String res: ress){
            System.out.println(res);
        }
    }
}
