
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
