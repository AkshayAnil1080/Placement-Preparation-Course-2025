

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
    public ListNode mergeKLists(ListNode[] lists) {
         // Step 1: Define a min heap based on ListNode value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );


        // Step 2: Add head of each non-null list to the minHeap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Step 3: Create a dummy node to build the result
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // Step 4: Build the merged list
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll(); // getting node smallest value
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next); // push next node from same list
            }
        }
        return dummy.next;
    }
}





//
M2

//time
 n = number of ele in each list. 
    // n+ 2n+ 3n +....n*k = n(k(k+1)/2) = n*k^2
 Space:  O(1)

Merge one by one

//  time : O(k * k * n)
// space : O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       ListNode res = null;
       for(ListNode curr : lists){
        res = merge(res, curr);
       }
       return res;
    }
    //   TC: O(n+m) ~ k*n =>  n = number of ele in each list. 
    // n+ 2n+ 3n +....n*k
 //SC: O(1)
    ListNode merge(ListNode h1, ListNode h2){
       // 1. Create a dummy node to track the head of the resultant list
        //1. crete dummy node to track head of the resultant LL
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy; 

        //2. traverse from both ll and (add, iterate) in the smaller one 
        while(h1!=null && h2!=null){
            if(h1.val <= h2.val){
            curr.next=h1;
              h1= h1.next;
            }
            else{
                curr.next = h2;
                h2=h2.next;
            }

             curr=curr.next;
        }
        //traverse through either remaining non empty list
        if(h1!=null){
            curr.next = h1;
        }
        else{
            curr.next=h2;
        }

        return dummy.next;
    }
}



M1
	1. Store all element into array
	2. Sort the array
	3. Travers and make a new LL
	Time : O(n*k)
Space: O(m*K)