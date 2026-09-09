class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, right = 0, longestLen = 0, strLen = s.length();
        Set<Character> seen = new HashSet<>();
        while (right < strLen) {
            Character curChar = s.charAt(right);
            if (!seen.contains(curChar)) {
                seen.add(curChar);
            } else {
                longestLen = Math.max(longestLen, right - left);
                while (left < right && s.charAt(left) != curChar) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                if (s.charAt(left) == curChar) {
                    left++;
                }
            }
                right++;
        }
        return Math.max(longestLen, right - left);
    }
}