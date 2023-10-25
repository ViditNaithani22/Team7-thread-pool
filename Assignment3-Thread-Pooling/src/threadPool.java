import java.util.concurrent.atomic.AtomicBoolean;

public class threadPool extends Thread {
    private AtomicBoolean stopFlag;
    array arr;

    public threadPool(array arr, AtomicBoolean stopFlag) {
        this.arr = arr;
        this.stopFlag = stopFlag;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !stopFlag.get()) {
            if (arr.getArray().size() == 0) {
                Thread.currentThread().interrupt(); // Interrupt the thread
                stopFlag.set(true);
                break;
            }
            arr.sumOfAll();
        }
    }

    void create10Threads() {
        AtomicBoolean stopFlag = new AtomicBoolean(false);
        threadPool[] threads = new threadPool[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new threadPool(arr, stopFlag);
            threads[i].start();
        }
        
        
    }
}