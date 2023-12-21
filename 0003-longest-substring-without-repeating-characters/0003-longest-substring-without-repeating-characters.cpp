class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> lastSeen;
        int l = 0, r = 0;
        int bestLength = 0;

        while (r < s.size()) {
            char c = s[r];
            if (lastSeen.count(c)) {
                l = max(l, lastSeen[c] + 1);
            }

            lastSeen[c] = r;
            bestLength = max(bestLength, r - l + 1);
            ++r;
        }

        return bestLength;
    }
};