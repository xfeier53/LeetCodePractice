//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always exist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
//

class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int count = hm.get(nums[i]) + 1;
                hm.put(nums[i], count);
                if (count > majority) {
                    return nums[i];
                }
            } else {
                hm.put(nums[i], 1);
            }

        }
        return nums[0];

//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hm.containsKey(nums[i])) {
//                hm.put(nums[i], hm.get(nums[i])+ 1);
//            } else {
//                hm.put(nums[i], 1);
//            }
//        }
//        int majority = nums.length / 2;
//        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
//            if (entry.getValue() > majority) {
//                return entry.getKey();
//            }
//        }
//        return -1;
    }
}