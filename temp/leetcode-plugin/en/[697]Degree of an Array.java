//Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements. 
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums. 
//
// Example 1: 
// 
//Input: [1, 2, 2, 3, 1]
//Output: 2
//Explanation: 
//The input array has a degree of 2 because both elements 1 and 2 appear twice.
//Of the subarrays that have the same degree:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//The shortest length is 2. So return 2.
// 
// 
//
//
// Example 2: 
// 
//Input: [1,2,2,3,1,4,2]
//Output: 6
// 
// 
//
// Note:
// nums.length will be between 1 and 50,000. 
// nums[i] will be an integer between 0 and 49,999. 
//

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        int max = 0;
        LinkedList<Integer> frequent = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == max) {
                frequent.add(entry.getKey());
            }
        }
        if (max <= 1) {
            return max;
        }
        int minimum = nums.length;
        for (Integer bound : frequent) {
            int lower = 0, upper = nums.length - 1;
            while (nums[lower] != bound || nums[upper] != bound) {
                if (nums[lower] != bound) {
                    lower++;
                }
                if (nums[upper] != bound) {
                    upper--;
                }
            }
            if (upper - lower + 1 < minimum) {
                minimum = upper - lower + 1;
            }
        }

        return minimum;
    }
}