package com.example.LinkedList;

/**
 * LinkedList를 이용한 덧셈
 */

class ListNode {
    int value;
    ListNode next;
    ListNode(int value) {
        this.value = value;
    }
}
public class AddTwoNumber {

    public static void main(String[] args) {
        AddTwoNumber a = new AddTwoNumber();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode result = a.solve(l1, l2);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private ListNode solve(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // 리턴되는 노드를 가리키기 위한 헤드 노드
        ListNode ln1 = l1, ln2 = l2, resultList = head;
        int carry = 0;
        while (ln1 != null || ln2 != null) {
            if (ln1 != null) {
                carry += ln1.value;
                ln1 = ln1.next;
            }
            if (ln2 != null) {
                carry += ln2.value;
                ln2 = ln2.next;
            }
            resultList.next = new ListNode(carry%10); // 캐리되지 않는 값 즉, 1의 자리는 그대로 연산의 결과로 사용
            resultList = resultList.next; // 결과를 저장하기 위한 노드 다음으로 이동
            carry /= 10; // 캐리되는 값 즉, 10의 자리만 남겨줘야 함
        }
        if (carry >= 1) { // 마지막 노드까지 연산을 마치고 캐리가 남아있는 경우 (최대 1)
            resultList.next = new ListNode(1); // 마지막 노드에 캐리값 삽입
        }
        return head.next;
    }
}
