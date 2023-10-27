
public class threadPool extends Thread {
    array arr;

    public threadPool(array arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " entering synchronized method.");
        arr.sumOfAll();
        System.out.println("Thread " + Thread.currentThread().getName() + " exiting synchronized method.");
    }

    void create10Threads() {
        threadPool[] threads = new threadPool[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new threadPool(arr);
            threads[i].start();
        }

    }
}