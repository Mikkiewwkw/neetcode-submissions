class PrefixTree {
    Node head;
    class Node {
        Map<Character, Node> map = new HashMap<>();
        boolean mark = false;
    }

    public PrefixTree() {
         head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            cur.map.putIfAbsent(c, new Node());
            cur = cur.map.get(c);
        }
        cur.mark = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            if(!cur.map.containsKey(c)) return false;
            cur = cur.map.get(c);
        }
        return cur.mark;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            if(!cur.map.containsKey(c)) return false;
            cur = cur.map.get(c);
        }
        return true;
    }
}
