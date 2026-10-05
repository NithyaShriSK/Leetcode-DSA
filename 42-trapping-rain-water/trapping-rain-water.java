class Solution {
    public int trap(int[] height) {
        int total=0;
        int n=height.length;
        int i=0;
        int j=n-1;
        int leftmax=height[i];
        int rightmax=height[j];
        while(i<j){
            if(height[i]>leftmax){
                leftmax=height[i];
            }
            if(height[j]>rightmax){
                rightmax=height[j];
            }
            int min=Math.min(leftmax,rightmax);
            if(height[i]>height[j]){
                total+=min-height[j];
                j--;
            }
            else{
                total+=min-height[i];
                i++;
            }
            //System.out.println(i+" "+j+" "+total);
        }
        return total;
    }
}