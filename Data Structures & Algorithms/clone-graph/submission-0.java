/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null ) return node;
        Map<Integer, Node> map = new HashMap();
        Deque<Node> oldQueue = new ArrayDeque();

        oldQueue.offer(node);
        while (!oldQueue.isEmpty()) {
            Node oldNode = oldQueue.poll();
            Node newNode = new Node(oldNode.val);
            map.putIfAbsent(newNode.val, newNode);
            int size = oldNode.neighbors.size();
            for (int i = 0; i < size; i++) {
                Node oldNeighbor = oldNode.neighbors.get(i);
                if (!map.containsKey(oldNeighbor.val)) {
                    oldQueue.offer(oldNeighbor);
                }

                // establish both adjacency list
                map.putIfAbsent(oldNeighbor.val, new Node(oldNeighbor.val));
                map.get(oldNode.val).neighbors.add(map.get(oldNeighbor.val));
            }
        }
        return map.get(node.val);
    }
}