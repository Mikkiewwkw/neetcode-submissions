class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) return 1;
        Set<Character> uniqueChars = new HashSet();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int maxCount = 0;
        for (Character c : uniqueChars) {
            int left = 0, count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }

                while (i - left + 1 - count > k) {
                    if (s.charAt(left) == c) {
                        count--;
                    }
                    left++;
                }
                maxCount = Math.max(maxCount, i - left + 1);
            }
        }
        return maxCount;
    }
}
// AABABBA k 1
// l 0 i 0 max 0 count 0