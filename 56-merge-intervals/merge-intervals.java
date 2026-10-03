class Solution {
    public int[][] merge(int[][] arr) {
        Stack<int[]> st=new Stack();
        int n=arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<n;i++){
            if(!st.empty()){
                int[] temp=st.peek();
                if(temp[1]>=arr[i][0]){
                    st.pop();
                    st.push(new int[]{temp[0], Math.max(temp[1], arr[i][1])});
                }
                else{
                    st.push(arr[i]);
                }
            }
            else{
                st.push(arr[i]);
            }
        }
        int[][] res=new int[st.size()][2];
        for(int i=st.size()-1;i>=0;i--){
            if(!st.empty()){
                int[] temp=st.pop();
            res[i][0]=temp[0];
            res[i][1]=temp[1];

            }
        }return res;
    }
}