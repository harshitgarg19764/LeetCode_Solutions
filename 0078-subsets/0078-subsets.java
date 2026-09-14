class Solution {
    public void helper(List<List<Integer>> list,List<Integer> l,int[] nums,int i){
        if(i==nums.length){
            list.add(new ArrayList(l));
            return;
        }
        l.add(nums[i]);
        int a = i;
        helper(list,l,nums,i+1);
        l.remove(l.size()-1);
        helper(list,l,nums,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        helper(list,l,nums,0);
        return list;
    }
}