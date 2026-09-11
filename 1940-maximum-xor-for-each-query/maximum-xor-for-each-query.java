class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int l=nums.length;
        int[] res=new int[l];
        int xor=0;
        for(int i=0;i<l;i++){
            xor^=nums[i];
        }
        int target = (1 << maximumBit) - 1;
        for(int i=0;i<l;i++){
            res[i]=xor^target;
            xor^=nums[l-i-1];
        }
        return res;
    }
}