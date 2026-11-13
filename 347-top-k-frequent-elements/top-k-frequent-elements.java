class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>m=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i],m.get(nums[i])+1);
            }
            else{
                m.put(nums[i],1);
            }
        }
        List<Integer> li = new ArrayList<>(m.keySet());
        Collections.sort(li, (a, b) -> m.get(b) - m.get(a));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = li.get(i);
        }
        return res;
    }
}