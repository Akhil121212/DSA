class Solution {
public:
    string convert(string s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
            return s;

        vector<string> rows(numRows);

        int index = 0;

        while (index < s.length()) {

           
            for (int i = 0; i < numRows && index < s.length(); i++)
                rows[i] += s[index++];

        
            for (int i = numRows - 2; i >= 1 && index < s.length(); i--)
                rows[i] += s[index++];
        }

        string ans;
        for (string &row : rows)
            ans += row;

        return ans;
    }
};