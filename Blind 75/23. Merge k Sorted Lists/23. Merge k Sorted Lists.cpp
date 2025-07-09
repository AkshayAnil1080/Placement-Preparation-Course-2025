
M3
Using min heap
	1. Define min heap and add  1st node from all k lists
	2. While heap is not empty
		a. Get the smallest one using poll method
		b. Then add in the resultant list
		c. Push the next node from same list
	3. Return resultant head.
	
	Time : O(n*k)logK
Space: O(k)
class Solution {
public:
    struct compare {
        bool operator()(ListNode* a, ListNode* b) {
            return a->val > b->val;  // min-heap: smallest value comes first
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, compare> minHeap;

        // Step 1: Push head of each non-null list into the heap
        for (ListNode* node : lists) {
            if (node != nullptr) {
                minHeap.push(node);
            }
        }

        // Step 2: Dummy node for result list
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;

        // Step 3: Build the merged list
        while (!minHeap.empty()) {
            ListNode* smallest = minHeap.top();
            minHeap.pop();

            curr->next = smallest;
            curr = curr->next;

            if (smallest->next != nullptr) {
                minHeap.push(smallest->next);
            }
        }

        return dummy->next;
    }
};


M2

//time
 n = number of ele in each list. 
    // n+ 2n+ 3n +....n*k = n(k(k+1)/2) = n*k^2
 Space:  O(1)

Merge one by one
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* res = nullptr;

        for (ListNode* curr : lists) {
            res = merge(res, curr);
        }

        return res;
    }

private:
    // Merge two sorted linked lists
    ListNode* merge(ListNode* h1, ListNode* h2) {
        // 1. Dummy node to build merged list
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;

        // 2. Merge both lists
        while (h1 != nullptr && h2 != nullptr) {
            if (h1->val <= h2->val) {
                curr->next = h1;
                h1 = h1->next;
            } else {
                curr->next = h2;
                h2 = h2->next;
            }
            curr = curr->next;
        }

        // 3. Attach remaining part
        if (h1 != nullptr) {
            curr->next = h1;
        } else {
            curr->next = h2;
        }

        return dummy->next;
    }
};

//


