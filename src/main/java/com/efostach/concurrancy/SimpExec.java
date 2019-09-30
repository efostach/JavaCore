package com.efostach.concurrancy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
    public static void main(String args[]) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");

        //запустить потоки исполнения
        es.execute(new NewThread(cd1, "A"));
        es.execute(new NewThread(cd2, "B"));
        es.execute(new NewThread(cd3, "C"));
        es.execute(new NewThread(cd4, "D"));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        es.shutdown();
        System.out.println("Завершение потоков");
    }

    static class NewThread implements Runnable {
        String name;
        CountDownLatch latch;

        NewThread(CountDownLatch c, String n) {
            latch = c;
            name = n;

            new Thread(this);
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i);
                latch.countDown();
            }
        }
    }
}
