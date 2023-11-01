import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class array {
    private Queue<AtomicLong> theArray = new LinkedList<>();
    private AtomicLong result = new AtomicLong(0);
    private final Object lock = new Object();

    public array(int x) {
        for (int i = 1; i <= x; i++) {
            theArray.add(new AtomicLong(i));
        }
    }

    public void sumOfAll() {
        long start = System.currentTimeMillis();
        while (true) {
            
            AtomicLong firstValue;
            AtomicLong secondValue;

            synchronized (lock) {
                if (theArray.size() == 1) {
                    // Once the last element is reached, obtain the answer
                    result.set(theArray.poll().get() + result.get());
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println("Time Elapsed: " + timeElapsed);
                    System.out.println("Final Result: " + result);
                    break;
                } else if (theArray.size() == 0) {
                    break;
                }
                // Remove the first and second element from the array
                firstValue = theArray.poll();
                secondValue = theArray.poll();

            }
            if (secondValue != null) {
                // If the second value is null, compute the sum
                long first = firstValue.get();
                long second = secondValue.get();
                long ans = first + second;
                synchronized (lock) {
                    theArray.add(new AtomicLong(ans));
                }
                System.out
                        .println(Thread.currentThread().getName() + " is working: " + first + "+" + second + "=" + ans);
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public Queue<AtomicLong> getArray() {
        return theArray;
    }
}