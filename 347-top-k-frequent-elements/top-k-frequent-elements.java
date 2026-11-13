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
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> m.get(b) - m.get(a)
        );
        for (int key : m.keySet()) {
            pq.add(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
    
}