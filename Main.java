package CodeWars;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.remove();
        notifyAll();
        return item;
    }
}

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(10);

        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    queue.enqueue(i);
//                    System.out.println("Producer 1: Enqueued " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 101; i <= 200; i++) {
                    queue.enqueue(i);
//                    System.out.println("Producer 2: Enqueued " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.dequeue();
                    System.out.println("Consumer 1: Dequeued " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.dequeue();
                    System.out.println("Consumer 2: Dequeued " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}