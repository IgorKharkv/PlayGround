// Written by Igor Kharkovskiy - 321228215 & Yarden Algoar - 319096103

import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String args[]) {
        Thread test = new Thread(new DeadLockDemo());
        Thread test2 = new Thread(new DeadLockDemo2());
        test.start();
        test2.start();
    }
}

class DeadLockDemo implements Runnable{
    /*
     * This method request two locks, first String and then Integer
     */
    public void method1() {
        try {
            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
                Thread.sleep(1000);
                synchronized (Integer.class) {
                    System.out.println("Aquired lock on Integer.class object");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.method1();
    }
}

class DeadLockDemo2 implements Runnable{

    /*
     * This method also requests same two lock but in exactly
     * Opposite order i.e. first Integer and then String.
     * This creates potential deadlock, if one thread holds String lock
     * and other holds Integer lock and they wait for each other, forever.
     */
    public void method2() {
        try {
            Thread.sleep(1000);
            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
                synchronized (String.class) {
                    System.out.println("Aquired lock on String.class object");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.method2();
    }
}