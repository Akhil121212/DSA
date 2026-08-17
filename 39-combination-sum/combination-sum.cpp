class Solution {
public:
    void solve(vector<int>& candidates, int target, int index,
               vector<int>& output, vector<vector<int>>& ans, int sum) {
        if (sum == target) {
            ans.push_back(output);
            return;
        }

        if (index >= candidates.size() || sum > target) {
            return;
        }
        output.push_back(candidates[index]);
        solve(candidates, target, index, output, ans, sum + candidates[index]);

        output.pop_back();
        solve(candidates, target, index + 1, output, ans, sum);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> output;
        solve(candidates, target, 0, output, ans, 0);
        return ans;
    }
};