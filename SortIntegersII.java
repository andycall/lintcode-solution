public class Solution {
     /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        sort(A, 0, A.length - 1);
    }

    private void sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int middle = A[start + (end - start) / 2];

        while (left <= right) {
            while (left <= right && A[left] < middle) {
                left++;
            }

            while (left <= right && A[right] > middle) {
                right--;
            }

            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        sort(A, start, right);
        sort(A, left, end);
    }

    private void swap(int[] A, int p, int q) {
        int tmp = A[p];
        A[p] = A[q];
        A[q] = tmp;
    }
}