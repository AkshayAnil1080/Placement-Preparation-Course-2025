Video link Solution - https://youtu.be/mRJQVMHSquo
Problem Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/1686086222/?envType=problem-list-v2&envId=oizxjoit
o(2N), o(1)
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // Step 1: Get the length of the list
        ListNode* curr = head;
        int length = 0;
        while (curr != nullptr) {
            length++;
            curr = curr->next;
        }

        // Step 2: If we need to remove the head node
        if (n == length) {
            return head->next;
        }

        // Step 3: Move to (length - n - 1)th node
        curr = head;
        for (int i = 1; i < length - n; i++) {
            curr = curr->next;
        }

        // Step 4: Remove the nth node from end
        if (curr->next != nullptr) {
            curr->next = curr->next->next;
        }

        return head; 
    }
};

o(N), o(1)
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // Step 1: Get the length of the list
       int len = 1;  // to track total length
        ListNode* slow = head;
        ListNode* fast = head;

        // Move fast n steps ahead and count length
        for (int i = 0; i < n; i++) {
            if (fast->next != nullptr) {
                fast = fast->next;
                len++;
            }
        }

        // Move both fast and slow pointers
        while (fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next;
            len++;
        }

        // If we need to remove the head node
        if (len == n) {
            return head->next;
        }

        // Remove nth node from end
        slow->next = slow->next->next;

        return head;
    }
};