package com.efostach.concurrancy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main (String args[]) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков.");

        new TestThread(cb, "A");
        new TestThread(cb, "B");
        new TestThread(cb, "C");
        new TestThread(cb, "X");
        new TestThread(cb, "Y");
        new TestThread(cb, "Z");
    }
}

//поток исполнения использующий барьер
class TestThread implements Runnable {
    CyclicBarrier cbar;
    String name;

    TestThread(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException | InterruptedException ex) {
            System.out.println(ex);
        }
    }
}

//объект класса вызывается по достижении барьера
class BarAction implements Runnable {
    public void run() {
        System.out.println("Барьер достигнут.");
    }
}
