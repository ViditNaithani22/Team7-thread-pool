import java.util.LinkedList;
import java.util.Queue;

public class array {
    // this queue stores integers from 1 to x.
    private Queue<Integer> theArray = new LinkedList<Integer>();

    int arrSize;

    public array(int x) {
        for (int i = 1; i < x + 1; i++) {
            theArray.add(i);
        }
    }

    // given method to add all the integers
    void sumOfAll() {
        arrSize = theArray.size();
        while (arrSize > 2 && !theArray.isEmpty() ) {
            addInt();
        }
        arrSize = theArray.size();
        if (!theArray.isEmpty() && arrSize == 1){
            Integer finalValue = theArray.poll();
            if (finalValue != null) {
                     System.out.println("Final Answer:" + finalValue);
                }
        }
        
    }

    // add two integers at a time and the only way to access the queue.
    void addInt() {
        arrSize = theArray.size();

        int first = 0;
        if (!theArray.isEmpty()) {
            Integer firstValue = theArray.poll();

            if (firstValue != null) {
                first = firstValue;
            }

            int second = 0;

            if (!theArray.isEmpty()) {
                Integer secondValue = theArray.poll();
                if (secondValue != null) {
                    second = secondValue;
                }

                int ans = first + second;

                theArray.add(ans);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(ans);
            }
        }   
    }

    public Queue getArray() {
        return theArray;
    }

}