class Solution
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,(arr1,arr2) -> arr1[0]-arr2[0]);
        List<int[]> output=new ArrayList<>();
        int[] current=intervals[0];
        output.add(current);
        for(int[] interval : intervals) 
        {
            int currentend=current[1];
            int nextbegin=interval[0];
            int nextend=interval[1];

                if(currentend>=nextbegin) 
                {
                    current[1]=Math.max(currentend,nextend);
                }
                else 
                {
                    current=interval;
                    output.add(current);
                }
            }
         return output.toArray(new int[output.size()][]);
        }         
    }
