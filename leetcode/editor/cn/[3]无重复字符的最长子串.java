//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 11147 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法1：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        // 获取字符串长度
        int n = s.length();
        // 使用HashSet存储窗口中的字符，用于快速判断是否有重复字符
        Set<Character> set = new HashSet<>();
        // ans记录最长子串长度，i为窗口左边界，j为窗口右边界
        int ans = 0, i = 0, j = 0;

        // 滑动窗口算法：右边界j遍历整个字符串
        while (i < n && j < n) {
            // 如果当前字符不在HashSet中，说明没有重复
            if (!set.contains(s.charAt(j))) {
                // 将当前字符加入HashSet，同时右边界j向右移动一位
                set.add(s.charAt(j++));
                // 更新最大长度为当前窗口大小和之前最大长度的较大值
                ans = Math.max(ans, j - i);
            } else {
                // 如果当前字符在HashSet中，说明有重复
                // 移除左边界字符，并将左边界i向右移动一位
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

//    // 方法2：滑动窗口
//    public int lengthOfLongestSubstring(String s) {
//        // 获取字符串长度
//        int n = s.length(), ans = 0;
//        // 使用HashMap存储字符及其最新出现的位置索引
//        Map<Character, Integer> map = new HashMap<>();
//        // 滑动窗口：i为右边界，j为左边界
//        for (int i = 0, j = 0; i < n; i++) {
//            // 如果当前字符已经在map中存在（即在当前窗口中出现过）
//            if (map.containsKey(s.charAt(i))) {
//                // 更新左边界j为当前位置和重复字符位置+1的最大值
//                // 确保窗口内没有重复字符
//                j = Math.max(j, map.get(s.charAt(i)) + 1);
//            }
//            // 将当前字符及其位置存入map中
//            map.put(s.charAt(i), i);
//            // 计算当前窗口长度并更新最大长度
//            ans = Math.max(ans, i - j + 1);
//        }
//        return ans;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
