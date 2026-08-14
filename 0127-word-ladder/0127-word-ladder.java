class Pair{
    String str;
    int dist;
    Pair(String str,int dist){
        this.str=str;
        this.dist=dist;
    }
}
class Solution {
    public boolean oneStringDiff(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        if(diff==1) return true;
        else{
            return false;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            // wordList.remove(curr.str);
            if(curr.str.equals(endWord)){
                return curr.dist;
            }
            if(!set.contains(curr.str)){
                set.add(curr.str);
                for(int i=0;i<wordList.size();i++){
                    if(!set.contains(wordList.get(i))){
                        if(oneStringDiff(curr.str,wordList.get(i))){
                            q.add(new Pair(wordList.get(i),curr.dist+1));
                        }
                    }
                }
            }
        }
        return 0;
    }
}