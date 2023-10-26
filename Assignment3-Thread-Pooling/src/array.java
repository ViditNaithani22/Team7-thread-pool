import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class array {
    private Queue<AtomicInteger> theArray = new LinkedList<>();
    private AtomicInteger result = new AtomicInteger(0);
    private final Object lock = new Object();

    public array(int x) {
        for (int i = 1; i <= x; i++) {
            theArray.add(new AtomicInteger(i));
        }
    }

    public int sumOfAll() {
        long start = System.currentTimeMillis();
        while (true) {
            AtomicInteger firstValue;
            AtomicInteger secondValue;

            synchronized (lock) {
                if (theArray.size() == 1) {
                    result.set(theArray.poll().get());
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println("Time Elapsed: " + timeElapsed);
                    System.out.println("Final Result: " + result);
                    break;
                } else if (theArray.size() == 0) {
                    break;
                }

                firstValue = theArray.poll();
                secondValue = theArray.poll();
            }

            if (secondValue != null) {
                int first = firstValue.get();
                int second = secondValue.get();
                int ans = first + second;
                synchronized (lock) {
                    theArray.add(new AtomicInteger(ans));
                }
                System.out.println(ans);
            }
            try {
                Thread.sleep(50); // Add a pause of 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result.get();
    }

    public Queue<AtomicInteger> getArray() {
        return theArray;
    }
}
