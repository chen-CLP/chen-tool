package com.chen.letcode;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/2/5 11:08
 * @Version: v1.0
 */
public class TwentyFour {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || null == head.next) {
            return head;
        }
        ListNode next = head;
        head = null;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        ListNode end = null;
        while (next != null && next.next != null) {
            tmp1 = next.next;
            tmp2 = next;
            next = next.next.next;
            tmp2.next = tmp1.next;
            tmp1.next = tmp2;
            if (head == null) {
                head = tmp1;
                end = tmp2;
                continue;
            }
            end.next = tmp1;
            end = tmp2;
        }
        return head;
    }
}
