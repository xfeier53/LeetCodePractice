//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
// 
//
// 
// Example 2: 
//
// 
//Input: [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A is sorted in non-decreasing order. 
// 
// 
//

class Solution {
    public int[] sortedSquares(int[] A) {
        int min = (int)Math.pow(A[A.length - 1], 2), index = 0;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)Math.pow(A[i], 2);
            if (A[i] <= min) {
                index = i;
                min = A[i];
            } else {
                continue;
            }
        }

        result[0] = A[index];
        int head = index - 1, tail = index + 1;
        for (int i = 1; i < A.length; i++) {
            if (head < 0) {
                result[i] = A[tail];
                tail++;
            } else if (tail > A.length - 1) {
                result[i] = A[head];
                head--;
            } else if (A[head] <= A[tail]) {
                result[i] = A[head];
                head--;
            } else if (A[tail] < A[head]){
                result[i] = A[tail];
                tail++;
            }
        }

        return result;
    }
}