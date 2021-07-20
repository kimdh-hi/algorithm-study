package com.example.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 오름차순으로 입력된 각 LinkedList를 오름차순으로 병합
 *
 * pq를 이용한 min-heap 풀이
 */

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists a = new MergeKSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(7);

        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        ListNode result = a.solve(list);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private ListNode solve(List<ListNode> list) {
        ListNode resultHead = new ListNode(0);
        ListNode resultNode = resultHead;
        Queue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        // 모든 ListNode를 pq에 삽입
        for (ListNode listNode : list) {
            pq.offer(listNode);
        }

        while (!pq.isEmpty()) {
            ListNode pollNode = pq.poll(); // min-heap이므로 poll시 최소값 리턴
            resultNode.next = pollNode;
            resultNode = resultNode.next;

            if (pollNode.next != null) pq.offer(pollNode.next);
        }
        return resultHead.next;
    }

    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
