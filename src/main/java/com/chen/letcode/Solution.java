package com.chen.letcode;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Integer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static class ListNode {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        Set<Integer> res=new HashSet<>();
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                lists[i] = new ListNode(Integer.MAX_VALUE);
            }
        }
        boolean flag = true;
        ListNode header = null;
        ListNode end = null;
        ListNode nNext = null;
        while (flag) {
            flag = false;
            Arrays.sort(lists, (a, b) -> {
                return a.val - b.val;
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null||lists[i].val==Integer.MAX_VALUE) {
                    continue;
                }
                flag = true;
                if (header == null) {
                    header = new ListNode(lists[i].val);
                    end = header;
                    lists[i] = lists[i].next;
                    break;
                }
                end.next = new ListNode(lists[i].val);
                nNext = end.next;
                lists[i] = lists[i].next;
                while (lists[i] != null && i < lists.length - 1 && lists[i + 1] != null && lists[i].val <= lists[i + 1].val) {
                    nNext.next = new ListNode(lists[i].val);
                    lists[i] = lists[i].next;
                    nNext = nNext.next;
                }
                end = nNext;
                if (i > 0 && lists[i] != null && lists[i - 1] != null && lists[i].val >= lists[i - 1].val) {
                    break;
                }
            }
        }
        return header;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode();
        lists[0].val = 2;
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode();
        lists[2] = new ListNode();
        lists[2].val = -1;
        mergeKLists(lists);
    }
}
