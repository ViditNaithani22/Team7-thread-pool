import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class array {
    // This queue stores AtomicIntegers.
    private Queue<AtomicInteger> theArray = new LinkedList<>();

    private AtomicInteger result = new AtomicInteger(0);

    public array(int x) {
        for (int i = 1; i <= x; i++) {
            theArray.add(new AtomicInteger(i));
        }
    }

    // Given method to add all the integers
    public int sumOfAll() {
        long start = System.currentTimeMillis();
        while (!theArray.isEmpty()) {
            addInt();

            if (theArray.size() == 1) {
                result.set(theArray.poll().get());
                long finish = System.currentTimeMillis();
                long timeElapsed = finish - start;
                System.out.println("Time Elapsed: " + timeElapsed);
                System.out.println("Final Result: " + result);
            }
        }
        return result.get();
    }

    // Add two integers at a time using AtomicInteger and ensure thread safety.
    public void addInt() {
        if (!theArray.isEmpty()) {
            AtomicInteger firstValue = theArray.poll();
            

            if (!theArray.isEmpty()) {
                AtomicInteger secondValue = null;
                secondValue = theArray.poll();

                if (secondValue != null) {
                    int ans = firstValue.get() + secondValue.get();
                    theArray.add(new AtomicInteger(ans));

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    if (!theArray.isEmpty()) {
                        System.out.println(ans);
                    }
                }
            }
        }
    }

    public Queue<AtomicInteger> getArray() {
        return theArray;
    }
}
