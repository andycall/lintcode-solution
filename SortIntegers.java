public class Solution {
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        int max = 0;
        
        for(int i = 0 ; i < A.length; i ++) {
            for(int j = i; j < A.length; j ++) {
                if (A[i] > A[j]) {
                    swap(A, i, j);
                }
            }
        }
    }
}