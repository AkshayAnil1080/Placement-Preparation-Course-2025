Video link Solution- https://youtu.be/5JmfzfhDZKc
Problem Link - https://leetcode.com/problems/3sum/?envType=problem-list-v2&envId=oizxjoit

O(n^3),O(n)
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
         set<vector<int>> triplets; // to avoid duplicates
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        vector<int> triplet = {nums[i], nums[j], nums[k]};
                        sort(triplet.begin(), triplet.end()); // to ensure duplicate triplets are same
                        triplets.insert(triplet); // set ensures uniqueness
                    }
                }
            }
        }

        // Convert set to vector
        vector<vector<int>> result(triplets.begin(), triplets.end());
        return result;
    }
};

o(n^2), O(1)
// 
// sort it
//2. itr i =0 i<n-2 , first ptr i , secont ptr i +1, third at last;
//3 consisering i at stagnant ptr, problem becomes find pair sum(0-nums[i]) in range  of sorted array(i+1 , n-1)
//4. while finding two pari sum, do not consider the same ele twice (as sol must not contain dup triplets) so skip the ele(use while loop and adj checking, as it sorted)
//finally apply find pair cases == if sum found - move from both dir, if curr_sum > target => high-- , else low++; -  u know this  -- std prob of finding pair sum in sorted array
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
         sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        
        for (int i = 0; i < nums.size() - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int low = i + 1;
            int high = nums.size() - 1;
            int target = 0 - nums[i];

            while (low < high) {
                int curr_sum = nums[low] + nums[high];

                if (curr_sum == target) {
                    result.push_back({nums[i], nums[low], nums[high]});
                    
                    // Skip duplicates for second and third elements
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    
                    low++;
                    high--;
                }
                else if (curr_sum < target) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }
        return result;
    }
};