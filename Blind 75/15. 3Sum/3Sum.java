Video link Solution-https://youtu.be/5JmfzfhDZKc
Problem Link - https://leetcode.com/problems/3sum/?envType=problem-list-v2&envId=oizxjoit

O(n^3),O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> al = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i]+ nums[j]+nums[k]==0){
                    List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k]);
                     Collections.sort(curr);  // to handle duplicates like [0, -1, 1] and [-1, 0, 1]
                        if(!set.contains(curr)){
                                al.add(curr);
                                set.add(curr);  
                        }
                    }
                }
            }
        }
    return al; 
    }
}

o(n^2), O(1)
// 
// sort it
//2. itr i =0 i<n-2 , first ptr i , secont ptr i +1, third at last;
//3 consisering i at stagnant ptr, problem becomes find pair sum(0-nums[i]) in range  of sorted array(i+1 , n-1)
//4. while finding two pari sum, do not consider the same ele twice (as sol must not contain dup triplets) so skip the ele(use while loop and adj checking, as it sorted)
//finally apply find pair cases == if sum found - move from both dir, if curr_sum > target => high-- , else low++; -  u know this  -- std prob of finding pair sum in sorted array

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> al = new LinkedList<>();
    
        for( int i =0; i<nums.length-2; i++)
        {
          if(i>0 && nums[i]==nums[i-1]) continue; // check if same ele not present else will add dup licate lists.
            
                int low =i+1;
                int high = nums.length -1;
                int sum = 0-nums[i]; // sum to findfor pair
            
            
                while(low<high)
                {
                    if(nums[low] +  nums[high] == sum)
                    {
                        al.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low<high && nums[low]==nums[low+1] ) low++;
                        while(low<high && nums[high]== nums[high-1]) high--;
                        
                        low++; high--;

                    }

                   else if(nums[low] +  nums[high] > sum)
                       high--;

                    else low++;
                }
            
        }
        return al;
    
    }
}
