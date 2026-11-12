class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>res=new ArrayList();
        Map<String,Integer>map=new HashMap();
        for(int i=0;i<=s.length()-10;i++){
            String str=s.substring(i,i+10);
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
            if(map.get(str)==2){
                res.add(str);
            }
        }
        return res;
    }
}