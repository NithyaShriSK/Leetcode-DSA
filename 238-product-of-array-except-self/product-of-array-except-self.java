class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre=new int[nums.length];
        int[] suf=new int[nums.length];
        int[] res=new int[nums.length];
        int preprod=1;
        pre[0]=preprod;
        for(int i=0;i<nums.length;i++){
            pre[i]=preprod;
            preprod*=nums[i];
        }
        int sufprod=1;
        suf[nums.length-1]=sufprod;
        for(int i=nums.length-1;i>=0;i--){
            suf[i]=sufprod;
            sufprod*=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            res[i]=pre[i]*suf[i];
            System.out.println(pre[i]+" "+suf[i]+" "+res[i]);
        }return res;
    }
}