package dataStuctures.linkedList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        long startTime=System.currentTimeMillis();
        ListNode merge = Merge(list1, list2);
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        while (merge != null) {
            System.out.println(merge);
            merge = merge.next;
        }

    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode merge = new ListNode(0);
        ListNode temp = merge;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            } else if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            }
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return merge.next;
    }
}
