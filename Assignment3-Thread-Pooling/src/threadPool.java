public class threadPool extends Thread{


    array arr;
    public threadPool(array arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        arr.sumOfAll();
    }


    void create10Threads(){
        threadPool th1 = new threadPool(arr);
        threadPool th2 = new threadPool(arr);
        threadPool th3 = new threadPool(arr);
        threadPool th4 = new threadPool(arr);
        threadPool th5 = new threadPool(arr);
        threadPool th6 = new threadPool(arr);
        threadPool th7 = new threadPool(arr);
        threadPool th8 = new threadPool(arr);
        threadPool th9 = new threadPool(arr);
        threadPool th10 = new threadPool(arr);


        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();


    }
}