public class Solution {
    private int BASE = 1000000;
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        if (target.length() == 0) {
            return 0;
        }
        
        int targetLength = target.length();
        int sourceLength = source.length();
        
        int power = 1;
        for(int i = 0; i < targetLength; i ++) {
            power = (power * 31) % BASE;   
        }
        
        int targetCode = 0;
        for(int i = 0; i < targetLength; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        
        int sourceCode = 0;
        for(int i = 0; i < sourceLength; i ++) {
            sourceCode = (sourceCode * 31 + source.charAt(i)) % BASE;
            if (i < targetLength - 1) {
                continue;
            }
            
            if (i >= targetLength) {
                sourceCode = sourceCode - (source.charAt(i - targetLength) * power) % BASE;
                
                if (sourceCode < 0) {
                    sourceCode += BASE;
                }
            }
            
            if (sourceCode == targetCode) {
                if (source.substring(i - targetLength + 1, i + 1).equals(target)) {
                    return i - targetLength + 1;
                }
            }
        }
        
        return -1;
    }
}