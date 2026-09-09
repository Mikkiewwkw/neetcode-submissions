class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, longestLen = 0, strLen = s.length();
        Map<Character, Integer> seen = new HashMap<>();
        for (int right = 0; right < strLen; right++) {
            if (seen.containsKey(s.charAt(right))) {
                left = Math.max(left, seen.get(s.charAt(right)) + 1);
            }
            seen.put(s.charAt(right), right);
            longestLen = Math.max(longestLen, right - left + 1);
        }
        return longestLen;
    }
}