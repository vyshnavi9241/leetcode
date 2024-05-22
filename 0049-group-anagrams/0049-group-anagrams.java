class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mapOfAnagrams=new HashMap<String,List<String>>();
        List<List<String>> output=new ArrayList<List<String>>();
        for(String word:strs) {
            char[] characters=word.toCharArray();
            Arrays.sort(characters);
            String sortedWord=new String(characters);
            if(!(mapOfAnagrams.containsKey(sortedWord))) {
                List<String> values=new ArrayList<String>();
                values.add(word);
                mapOfAnagrams.put(sortedWord,values);
                output.add(values);
            }
            else
            {
                mapOfAnagrams.get(sortedWord).add(word);
            }    
        }
         return output;
    }
}