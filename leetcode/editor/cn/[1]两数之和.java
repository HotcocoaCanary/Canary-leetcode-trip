//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 20332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    /**
//     * 寻找数组中两个数的和等于目标值的下标
//     *
//     * @param nums   输入的整数数组
//     * @param target 目标和值
//     * @return 返回两个数字的数组下标，如果未找到则返回空数组
//     */
//    public int[] twoSum(int[] nums, int target) {
//        // 使用双重循环遍历所有可能的两个数的组合
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                // 如果两个数的和等于目标值，则返回这两个数的下标
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        // 如果没有找到符合条件的两个数，返回空数组
//        return new int[0];
//    }
    /**
     * 寻找数组中两个数的和等于目标值的下标
     *
     * @param nums   输入的整数数组
     * @param target 目标和值
     * @return 返回两个数字的数组下标，如果未找到则返回空数组
     */
    public int[] twoSum(int[] nums, int target) {
        // 使用哈希表存储已遍历过的数字及其索引，实现一次遍历查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算当前数字与目标值的差值（即需要寻找的另一个加数）
            int complement = target - nums[i];
            // 如果哈希表中存在这个差值，说明找到了两个加数
            if (map.containsKey(complement)) {
                // 返回找到的两个数字的下标数组
                return new int[]{map.get(complement), i};
            }
            // 将当前数字和其索引存入哈希表，供后续查找使用
            map.put(nums[i], i);
        }
        // 如果没有找到符合条件的两个数，返回空数组
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
