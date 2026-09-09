class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, right = 0, longestLen = 0, strLen = s.length();
        Map<Character, Integer> seen = new HashMap<>();
        while (right < strLen) {
            Character curChar = s.charAt(right);
            if (!seen.containsKey(curChar)) {
                seen.put(curChar, right);
            } else {
                longestLen = Math.max(longestLen, right - left);
                while (left < seen.get(curChar)) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                left = seen.get(curChar) + 1;
                seen.put(curChar, right);
            }
            right++;
        }
        return Math.max(longestLen, right - left);
    }
}