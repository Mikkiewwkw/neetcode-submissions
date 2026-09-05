class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char iChar = s.charAt(i);
            if (!map.containsKey(iChar)) {
                stack.push(iChar);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(iChar) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
