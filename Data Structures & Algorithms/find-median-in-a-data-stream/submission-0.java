class MedianFinder {
    private Queue<Integer> small;  // stores small half - maxHeap
    private Queue<Integer> big;  // stores big half - minHeap
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b.compareTo(a));
        big = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        big.add(small.poll());
        if (small.size() < big.size()) {
            small.add(big.poll());
        }
    }
    
    public double findMedian() {
        int smallSize = small.size();
        int bigSize = big.size();
        if (smallSize == bigSize) {
            return (double) (small.peek() + big.peek()) / 2.0;
        } else {
            return (double) small.peek();
        }
    }
}
