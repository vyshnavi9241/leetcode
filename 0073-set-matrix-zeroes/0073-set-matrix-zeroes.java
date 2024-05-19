class Solution {
    public void setZeroes(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList();
        
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    list.add(i);
                    break;
                }
            }
        }
        
        for (int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    for(int k=0; k<matrix.length; k++)
                    {
                        matrix[k][j] = 0;
                    }
                }
            }
            
            
        }
        
        for(Integer integer : list)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                matrix[integer][j] =0; 
            }
        }
    }
}