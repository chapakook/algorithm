/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode n1 = headA;
        while(n1 != null) {
            map.put(n1, n1.val);
            n1 = n1.next;
        }
        n1 = headB;
        while(n1 != null) {
            if(map.get(n1) != null) return n1;
            n1 = n1.next;
        }
        return null;
    }
}

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode n1 = headA;
        while(n1 != null) {
            set.add(n1);
            n1 = n1.next;
        }
        n1 = headB;
        while(n1 != null) {
            if(set.contains(n1)) return n1;
            n1 = n1.next;
        }
        return null;
    }
}

public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}