//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 11628 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // 创建虚拟头节点，便于操作链表
//        ListNode dummyHead = new ListNode(0);
//        // 定义指针p指向链表l1，q指向链表l2，curr指向结果链表当前节点
//        ListNode p = l1, q = l2, curr = dummyHead;
//        // 进位值初始化为0
//        int carry = 0;
//        // 当两个链表都未遍历完时继续循环
//        while (p != null || q != null) {
//            // 获取当前节点的值，如果节点为空则取0
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            // 计算当前位的和
//            int sum = carry + x + y;
//            // 更新进位值
//            carry = sum / 10;
//            // 将当前位的结果添加到新链表中
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            // 移动链表指针
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        // 如果最后还有进位，则添加新的节点
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        // 返回结果链表（跳过虚拟头节点）
//        return dummyHead.next;
//    }


    /**
     * 将两个用链表表示的数字相加
     * @param l1 第一个数字的链表表示
     * @param l2 第二个数字的链表表示
     * @return 两个数字之和的链表表示
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursion(l1, l2, 0);
    }

    /**
     * 递归方法实现两个链表数字相加
     * @param l1 第一个链表的当前节点
     * @param l2 第二个链表的当前节点
     * @param carry 进位值
     * @return 相加结果的新节点
     */
    private ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2, int carry){
        // 基础情况：当两个链表都遍历完成且无进位时，返回null
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        // 当前位置的值初始化为进位值
        int val = carry;
        
        // 如果l1不为空，加上l1当前节点的值
        if (l1 != null) {
            val += l1.val;
        }
        
        // 如果l2不为空，加上l2当前节点的值
        if (l2 != null) {
            val += l2.val;
        }
        
        // 创建新节点存储当前位的结果(个位数)
        ListNode node = new ListNode(val % 10);
        
        // 递归处理下一位，传入下一个节点和进位值(十位数)
        node.next = addTwoNumbersRecursion(
            l1 == null ? null : l1.next, 
            l2 == null ? null : l2.next, 
            val / 10
        );
        
        return node;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
