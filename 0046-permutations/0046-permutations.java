class Solution {
    void helper(List<List<Integer>>list,List<Integer> l,List<Integer> nums){
        if(nums.size()==0){
            list.add(new ArrayList(l));
            return;
        }
        for(int i=0;i<nums.size();i++){
            l.add(nums.get(i));
            int n = nums.remove(i);
            int a = i;
            helper(list,l,nums);
            l.remove(l.size()-1);
            nums.add(a,n);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            num.add(nums[i]);
        }
        helper(list,l,num);
        return list;
    }
}