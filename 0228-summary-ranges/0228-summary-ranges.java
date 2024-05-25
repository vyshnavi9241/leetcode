class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> output=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int start=nums[i];
            while(i+1<nums.length && nums[i+1]-nums[i]==1)
                i++;
            if(start!=nums[i]) {
                output.add("" +start+"->"+nums[i]);
            }
            else 
            {
                output.add("" +start);
            }
        }
        return output;
    }
}