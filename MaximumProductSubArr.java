public class MaximumProductSubArr {
    public static int maxProductSunnArr(int nums[]) {
        int ans = nums[0];
        int ma = ans;
        int mi = ans;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i] < 0) {
               int temp = ma;
               ma = mi;
               mi = temp;
            }
            ma = Math.max(nums[i], ma*nums[i]);
            mi = Math.min(nums[i], mi*nums[i]);
            ans = Math.max(ans, ma);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, 4 };
        System.out.println(maxProductSunnArr(nums));
    }
}
