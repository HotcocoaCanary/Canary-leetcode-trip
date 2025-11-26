//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2586 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        // 边界情况：行数为1或行数大于等于字符串长度，直接返回原字符串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int period = 2 * (numRows - 1); // Z字形的周期

        for (int i = 0; i < numRows; i++) {
            int index = i;
            // 交替的两个间隔：gap1 = period - 2*i，gap2 = 2*i
            int gap1 = period - 2 * i;
            int gap2 = 2 * i;
            boolean useGap1 = true; // 标记当前使用哪个间隔

            while (index < s.length()) {
                sb.append(s.charAt(index));

                // 首行或末行：固定使用period间隔（gap1和gap2相等）
                if (i == 0 || i == numRows - 1) {
                    index += period;
                } else {
                    // 中间行：交替使用gap1和gap2
                    index += useGap1 ? gap1 : gap2;
                    useGap1 = !useGap1;
                }
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
