import java.util.concurrent.atomic.AtomicBoolean;

public class Main2 {
    public static void main(String[] args) {
        array arr = new array(100);
        AtomicBoolean stopFlag = new AtomicBoolean(false);
        threadPool newPool = new threadPool(arr,stopFlag);

        newPool.create10Threads();

    }
}
