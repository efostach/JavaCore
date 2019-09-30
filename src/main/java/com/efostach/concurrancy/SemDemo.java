package com.efostach.concurrancy;

import java.util.concurrent.Semaphore;

public class SemDemo {
     public static void main(String args[]) {
         Semaphore sem = new Semaphore(1);

         new IncThread(sem, "A");
         new DecThread(sem, "B");
     }
}

//общий ресурс
class Shared {
    static int count = 0;
}


//поток исполнения, увеличивающий значение счетчика на 1
class IncThread implements Runnable {
    String name;
    Semaphore sem;
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения.");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение.");

            //получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                //разврешить, если возможно, переключение контекста
                Thread.sleep(10);
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение.");
        sem.release();
    }
}

//поток исполнения, уменьшающий значение счетчика на 1
class DecThread implements Runnable {
    String name;
    Semaphore sem;
    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения.");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение.");

            //получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                //разврешить, если возможно, переключение контекста
                Thread.sleep(10);
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение.");
        sem.release();
    }
}