class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> m=new HashMap();
        Map<Character,Integer>m2=new HashMap();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(m2.containsKey(ch)){
                m2.put(ch,m2.get(ch)+1);
            }
            else{
                m2.put(ch,1);
            }
        }
        int i=0;
        int j=0;
        int startindex=0;
        int endindex=0;
        int max=s.length()+1;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(m2.containsKey(ch)){
                if(m.containsKey(ch)){
                    m.put(ch,m.get(ch)+1);
                }
                else{
                    m.put(ch,1);
                }
            }
             while(m.size()==m2.size()){
                int flag=1;
                for(char chr : m2.keySet()) {
                    if(!m.containsKey(chr) || m.get(chr) < m2.get(chr)) {
                        flag = 0;
                        break;
                    }
                }
                if(flag == 0){
                    break;
                }

                if(j-i+1 < max && flag==1){
                    startindex=i;
                    endindex=j;
                    max=j-i+1;
                }
                char left=s.charAt(i);
                if(m.containsKey(left)){
                    if(m.get(left)>1){
                        m.put(left,m.get(left)-1);
                    }
                    else{
                        m.remove(left);
                    }
                }
                i++;
            }

            j++;
        }
        if(max==s.length()+1){
            return "";
        }

        return s.substring(startindex,endindex+1);
    }
}