public class Main2 {
    public static void main(String[] args) {
        array arr = new array(100000);
        threadPool newPool = new threadPool(arr);

        newPool.create10Threads();
    }
}
