package old.modul10;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main1 {
    static BlockingQueue q = new ArrayBlockingQueue(30);

    static int n = 15;
    public static void main(String[] args) throws InterruptedException {



        Thread fizzThread = new Thread(() -> {
            try {
                fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        fizzThread.join();
        buzzThread.join();
        fizzBuzzThread.join();
        numberThread.join();

        for (Object z : q){
            System.out.println(z);
        }
    }

    public static void fizz() throws InterruptedException {
//        for (int i = 3; i <= n; i += 3) {
//            if (i % 5 != 0) {

                q.add("fizz");

//            }
//        }
    }

    public static void buzz() throws InterruptedException {
//        for (int i = 5; i <= n; i += 5) {
//            if (i % 3 != 0) {

                q.add("buzz");

//            }
//        }
    }

    public static void fizzBuzz() throws InterruptedException {
      //  for (int i = 15; i <= n; i += 15) {

            q.add("fizzbuzz");

//        }
    }

    public static void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzz();
            } else if (i % 3 == 0) {
                fizz();
            } else if (i % 5 == 0) {
                buzz();
            } else {
                q.add(i);

            }
        }
    }



}
