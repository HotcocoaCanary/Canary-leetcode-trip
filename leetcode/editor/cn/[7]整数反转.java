//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 4135 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    public int reverse(int x) {
//        // 计算 -2^31 和 2^31 - 1
//        long minResult = -(long) Math.pow(2, 31);
//        long maxResult = (long) Math.pow(2, 31) - 1;
//
//        // 如果 x 是边界值或 0，直接返回 0
//        if (x == minResult || x == 0) {
//            return 0;
//        }
//
//        // 将整数转换为字符串
//        String str = Integer.toString(Math.abs(x));
//
//        // 使用 StringBuilder 反转字符串
//        StringBuilder rts = new StringBuilder();
//        for (int i = str.length() - 1; i >= 0; i--) {
//            rts.append(str.charAt(i));
//        }
//
//        // 将反转后的字符串转换为整数
//        try {
//            long reversed = Long.parseLong(rts.toString());
//            // 检查是否溢出
//            if (reversed > maxResult || reversed < minResult) {
//                return 0;
//            }
//            // 返回结果，注意符号
//            return (int) (x < 0 ? -reversed : reversed);
//        } catch (NumberFormatException e) {
//            return 0;
//        }
//    }
    public int reverse(int x) {
        // 用于存储反转后的结果
        long result = 0;

        // 处理负数
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }

        // 反转整数
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        // 检查是否溢出
        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        // 返回结果，注意符号
        return (int) (isNegative ? -result : result);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
