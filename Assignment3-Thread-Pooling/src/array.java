import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class array {
    //this queue stores integers from 1 to x.
    private Queue<Integer> theArray = new LinkedList<Integer>();

    //stores sum of all integers
    int answer = 0;

    public array(int x){
        for (int i = 1; i <x+1; i++){
            theArray.add(i);
        }
    }


    //given method to add all the integers
    int sumOfAll(){
        while (answer == 0){
            System.out.println(addInt());
        }
        return answer;
    }


    //add two integers at a time and the only way to access the queue.
    int addInt(){
        int first = 0;
        if(!theArray.isEmpty()) {
            first = theArray.poll();
        }
        int second = 0;
        if(!theArray.isEmpty()) {
            second = theArray.poll();
        }
        else {
            answer = first;
        }
        int ans = first+second;

        theArray.add(ans);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
        return ans;

    }


    public Queue getArray(){
        return theArray;
    }

}