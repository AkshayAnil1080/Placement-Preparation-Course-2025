Video link Solution- https://youtu.be/0qXFhacp5IY
Problem Link - https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=oizxjoit

O(n^2),O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        
        for(int i =0 ;i<nums.length;i++)
        {   for(int j =i+1 ;j<nums.length;j++)
            {
                if (nums[i]+nums[j] == target)
                {
                    arr[0]=i;
                    arr[1]= j;
                    break;
                }
            }
        }
        
        return arr;

    }
}
O(n),O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int arr[] = new int[2];
        
        for( int i =0 ;i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {i,map.get(target-nums[i])};
            }
            else
                map.put(nums[i],i);
        }
        return arr;
    }
}