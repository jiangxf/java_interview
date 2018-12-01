package com.blankj.easy._035_;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/02
 *     desc  :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(solution.searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {

            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;

            if (nums[left] >= target) return left;
            if (nums[right] == target) return right;
            if (nums[right] < target) return right + 1;
            if(left + 1 == right) return left + 1;

        }
        return left;
    }

//    public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = (right + left) >> 1;
//            if (target <= nums[mid]) right = mid - 1;
//            else left = mid + 1;
//        }
//        return left;
//    }
}
