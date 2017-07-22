/**
 * http://www.lintcode.com/en/problem/unique-characters/
 */

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        Map<String, Boolean> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i ++) {
            String s = str.substring(i, i + 1);
            if (map.containsKey(s)) {
                return false;
            }
            map.put(s, true);
        }
        
        return true;
    }
}