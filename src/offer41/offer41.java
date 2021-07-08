package offer41;

import java.lang.ref.SoftReference;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> bigHeap;
    private final PriorityQueue<Integer> smallHeap;

    public MedianFinder() {
        bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        smallHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigHeap.size() != smallHeap.size()) {
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
        } else {
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
        }
    }

    public double findMedian() {
        if (bigHeap.isEmpty()) return 0;
        if (bigHeap.size() != smallHeap.size()) return bigHeap.peek();
        else return (bigHeap.peek() + smallHeap.peek()) / 2.0;
    }
}
public class offer41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }
}
