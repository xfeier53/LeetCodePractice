//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may not use the same element twice. 
// 
//
// Example: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 
//

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min = 0, max = numbers.length - 1;
        while (numbers[min] + numbers[max] != target) {
            if (numbers[min] + numbers[max] < target) {
                min++;
            } else {
                max--;
            }
        }
        return new int[] {min + 1, max + 1};

//        int max = 1, temp;
//        while (numbers[max] <= target && max < numbers.length - 1) {
//            max++;
//        }
//        for (int i = 0; i < max; i++) {
//            if (numbers[i] + numbers[max] == target) {
//                return new int[] {i + 1, max + 1};
//            }
//            temp = max;
//            while (numbers[i] + numbers[temp] != target) {
//                if (numbers[i] + numbers[temp - 1] == target) {
//                    return new int[] {i + 1, temp};
//                } else if (numbers[i] + numbers[temp - 1] > target){
//                    temp--;
//                } else {
//                    break;
//                }
//            }
//
//        }
//        return new int[0];
    }
}