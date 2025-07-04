Video link Solution - https://youtu.be/mRJQVMHSquo
Problem Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/1686086222/?envType=problem-list-v2&envId=oizxjoit
o(2N), o(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1 get length
        ListNode curr=head;
        int length=0;
        while(curr!=null){
            length++; curr=curr.next;
        }

        //if remove head node
         if (n == length) {
            return head.next;
        }

        curr=head;
        for(int i=1; i<length-n;i++){
            curr=curr.next;
        }
        //remove nth node
        curr.next = curr.next.next;

        return head;
    }
}

o(N), o(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int len=1;  // to handle lenth of linked list == n - here have to remove head and return head.next;
        ListNode slow = head;
         ListNode fast = head;
        for(int i =0; i<n; i++)
        {
            if(fast.next!=null) 
            {
                fast=fast.next;
                len++;
            }
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
            len++;
        }
        if(len==n)//need to remove head
            return head.next;
        
        slow.next = slow.next.next;
        
        return head;
    }
}