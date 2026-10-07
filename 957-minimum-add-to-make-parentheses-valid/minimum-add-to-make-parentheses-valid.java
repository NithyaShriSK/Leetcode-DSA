class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open+=1;
            }
            else if(ch==')' && open>0){
                open-=1;
            }
            else{
                close+=1;
            }
        }return close+open;
    }
}