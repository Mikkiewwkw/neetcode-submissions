class PrefixTree {
    Node head;
    class Node {
        Map<Character, Node> map;
        boolean mark;
        public Node() {
            map = new HashMap<>();
            mark = false;
        }
        public Map<Character, Node> getMap() {
            return map;
        }
        public void insert(String word) {
            if (word.length() == 0) mark = true;
            if (word.length() > 0) {
                Node next = map.getOrDefault(word.charAt(0), new Node());
                map.put(word.charAt(0), next);
                next.insert(word.substring(1));
            }
        }
        public boolean search(String word) {
            if (word.length() == 0 && mark) return true;
            if (word.length() > 0 && map.containsKey(word.charAt(0))) {
                return map.get(word.charAt(0)).search(word.substring(1));
            }
            return false;
        }
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) return true;
            if (map.containsKey(prefix.charAt(0))) {
                return map.get(prefix.charAt(0)).startsWith(prefix.substring(1));
            }
            return false;
        }
    }

    public PrefixTree() {
         head = new Node();
    }

    public void insert(String word) {
        if (word.length() > 0) {
            Node next = head.getMap().getOrDefault(word.charAt(0), new Node());
            head.getMap().put(word.charAt(0), next);
            next.insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        if (word.length() > 0) {
            if (head.getMap().containsKey(word.charAt(0))) {
                return head.getMap().get(word.charAt(0)).search(word.substring(1));
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() > 0) {
            if (head.getMap().containsKey(prefix.charAt(0))) {
                return head.getMap().get(prefix.charAt(0)).startsWith(prefix.substring(1));
            }
        }
        return false;
    }
}
