//Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even. 
//
// Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even. 
//
// You may return any answer array that satisfies this condition. 
//
// 
//
// Example 1: 
//
// 
//Input: [4,2,5,7]
//Output: [4,5,2,7]
//Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
// 
//
// 
//
// Note: 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// 
//

class Solution {
    public int[] sortArrayByParityII(int[] A) {
//        int[] result = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//            if ((i % 2 == 0 && A[i] % 2 == 0) || (i % 2 != 0 && A[i] % 2 != 0)) {
//                result[i] = A[i];
//            } else {
//                if (i % 2 == 0) {
//                    for (int j = i + 1; j < A.length; j++) {
//                        if (j % 2 != 0 && A[j] % 2 == 0) {
//                            result[i] = A[j];
//                            A[j] = A[i];
//                            break;
//                        }
//                    }
//                } else {
//                    for (int j = i + 1; j < A.length; j++) {
//                        if (j % 2 == 0 && A[j] % 2 != 0) {
//                            result[i] = A[j];
//                            A[j] = A[i];
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return result;

//        int index = 0;
//        int[] result = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 == 0) {
//                result[index] = A[i];
//                index += 2;
//            }
//        }
//        index = 1;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 != 0) {
//                result[index] = A[i];
//                index += 2;
//            }
//        }
//        return result;

        int evenIndex = 0, oddIndex = 1;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[evenIndex] = A[i];
                evenIndex += 2;
            } else {
                result[oddIndex] = A[i];
                oddIndex += 2;
            }
        }
        return result;
    }
}