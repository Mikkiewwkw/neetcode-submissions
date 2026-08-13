class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        int leftPos;
        int rightPos;
        int leftValue;
        int rightValue;
        Arrays.sort(nums);
        int currentPos = 0;
        int currentValue;
        int iterationLength = nums.length - 2;
        while (currentPos < iterationLength) {
            currentValue = nums[currentPos];
            leftPos = currentPos + 1;
            rightPos = nums.length - 1;

            if (currentPos > 0 && currentValue == nums[currentPos - 1]) {
                currentPos++;
                continue;
            }

            while (leftPos < rightPos) {
                leftValue = nums[leftPos];
                rightValue = nums[rightPos];
                int sum = currentValue + leftValue + rightValue;

                if (sum == 0) {
                    List<Integer> triplet = new LinkedList(List.of(currentValue, leftValue, rightValue));
                    result.add(triplet);

                    while (leftPos < rightPos && leftValue == nums[leftPos + 1])
                        leftPos++;
                    while (leftPos < rightPos && rightValue == nums[rightPos - 1])
                        rightPos--;
                        
                    leftPos++;
                    rightPos--;
                } else if (sum < 0) {
                    leftPos++;
                } else {
                    rightPos--;
                }
            }
            currentPos++;

        }
        return result;
    }
}