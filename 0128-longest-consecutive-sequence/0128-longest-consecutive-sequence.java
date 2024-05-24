class Solution 
{
    public int longestConsecutive(int[] nums)
    {
        int max=0;
        Set<Integer> set1=new HashSet<>();
        for(int num : nums) {
            set1.add(num);
        }
        for(int num : nums) {
            if(!set1.contains(num-1)) {
                int start=num;
                while (set1.contains(start)) {
                    start++;
                }
                max=Math.max(max,start-num);
            }
        }
        return max;
    }
}