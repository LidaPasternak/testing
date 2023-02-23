package org.example;
//a)	Use a CountDownLatch to wait for a set of threads to complete before continuing execution in the main thread.
//b)	Create your own custom class extended from some another class, and make an object for it.
// Use getSuperclass() to print out the name of the superclass of the class. Use getInterfaces() to print out the names of all the interfaces implemented by the class.
//c)	Create a generic method that takes two parameters of any type, and returns the larger one using T extends Comparable<T> and compareTo().
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Task A
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);
        for (int i = 0; i < numThreads; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("Thread " + finalI + " working");
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("Finished");

        //Task B
        Cat cat = new Cat();
        System.out.println(cat.getClass().getSuperclass());
        System.out.println(Arrays.toString(cat.getClass().getInterfaces()));

        //Task C
        int a = 10;
        int b = 7;
        System.out.println(findBigger(a,b));
    }

    //Task C
    public static <T extends Comparable<T>> T findBigger(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }
}