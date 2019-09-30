package com.efostach.concurrancy;

public class NewThreadImplRunnable implements Runnable {
    Thread t;
    String name;

    NewThreadImplRunnable(String threadName) {
        //создать новый, второй поток исполнения
        name = threadName;
        t = new Thread(this, name);
        System.out.println(name + ": " + t);
        t.start();
    }

    //точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println(name + " прерван.");
        }
        System.out.println(name + " завершен.");
    }
}

/*
class ThreadDemo {
    public static void main(String args[]) {
        new NewThreadImplRunnable("Один");
        new NewThreadImplRunnable("Два");
        new NewThreadImplRunnable("Три");

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}
*/

class DemoJoin {
    public static void main(String args[]) {
        NewThreadImplRunnable ob1 = new NewThreadImplRunnable("Один");
        NewThreadImplRunnable ob2 = new NewThreadImplRunnable("Два");
        NewThreadImplRunnable ob3 = new NewThreadImplRunnable("Три");

        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob1.t.isAlive());
        System.out.println("Поток Три запущен: " + ob1.t.isAlive());

        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();

        } catch (InterruptedException ex) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob1.t.isAlive());
        System.out.println("Поток Три запущен: " + ob1.t.isAlive());

        System.out.println("Главный поток завершен.");
    }
}
