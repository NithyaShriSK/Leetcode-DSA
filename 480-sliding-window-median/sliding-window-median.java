
class Solution {

    PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> large =
        new PriorityQueue<>();

    HashMap<Integer, Integer> delayed = new HashMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }

        res[0] = getMedian(k);

        for (int i = k; i < nums.length; i++) {

            removeNum(nums[i-k]);
            addNum(nums[i]);

            res[i-k+1] = getMedian(k);
        }

        return res;
    }

    void addNum(int num) {

        prune(small);

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    void removeNum(int num) {

        prune(small);

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;

            if (num == small.peek()) {
                prune(small);
            }
        } else {
            largeSize--;

            if (!large.isEmpty() && num == large.peek()) {
                prune(large);
            }
        }

        balance();
    }

    void balance() {

        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        }
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            largeSize--;
            smallSize++;
            prune(large);
        }
    }

    void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (delayed.containsKey(num)) {

                heap.poll();

                int count = delayed.get(num);

                if (count == 1) {
                    delayed.remove(num);
                } else {
                    delayed.put(num, count - 1);
                }

            } else {
                break;
            }
        }
    }

    double getMedian(int k) {

        prune(small);
        prune(large);

        if (k % 2 != 0) {
            return small.peek();
        }

        return ((double) small.peek() + large.peek()) / 2.0;
    }
}
