class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> prevMap;
        for (int i = 0; i < nums.size(); i++) {
            int rem = target - nums[i];
            if (prevMap.find(rem) != prevMap.end()) {
                return {prevMap[rem], i};
            }
            prevMap.insert({nums[i], i});
        }
        return {};
    }
};
