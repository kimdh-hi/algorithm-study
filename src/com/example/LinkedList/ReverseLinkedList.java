package com.example.LinkedList;

/**
 * single Linked List reversing
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        System.out.println(list.val);
    }


    private ListNode solve(ListNode curr) {
        ListNode next = null;
        ListNode prev = null;

        while (curr != null) {
            // 현재 노드의 다음 노드를 임시 저장노드인 next에 저장
            next = curr.next;
            // prev에는 현재까지 역순으로 만든 노드가 저장되어 있음
            // 역순으로 저장된 노드를 가리키는 것으로 현재 노드도 역순이 되는 것.
            curr.next = prev;
            // 현재 노드까지를 포함한 역순으로 된 노드를 저장
            prev = curr;
            // next로 떼어난 임시 저장 노드를 현재 노드로 갱신
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
