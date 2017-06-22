public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        
        if (s == null) {
            return results;
        }
        
        // start from first word
        // walk through the index to the end, find every palindronme word, push
        List<String> partition = new ArrayList<String>();
        helper(s, 0, partition, results);
        
        return results;
    }
    
    private void helper(String str, int startIndex, List<String> partition, List<List<String>> results) {
        if (startIndex == str.length()) {
            results.add(new ArrayList<String>(partition));
            return;
        }
        
        for(int i = startIndex; i < str.length(); i ++) {
            String substring = str.substring(startIndex, i + 1);
            
            if (!isPalidrome(substring)) {
                continue;
            }
            partition.add(substring);
            helper(str, i + 1, partition, results);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalidrome(String str) {
        for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
}