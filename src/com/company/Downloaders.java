package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private Semaphore semaphore2;
    private CountDownLatch cdl;
    private CountDownLatch cdl2;

    private int volume = 500;
    private int speed = 100;


    public Downloaders(String name, Semaphore semaphore2, CountDownLatch cdl, CountDownLatch cdl2) {
        super(name);
        this.semaphore2 = semaphore2;
        this.cdl = cdl;
        this.cdl2 = cdl2;
    }

    public synchronized void run() {
        try {

            cdl2.await();

            semaphore2.acquire();
            System.out.println(getName() + " в очереди на скачивание");
            System.out.println(getName() +
                    "  скачивает файл со скоростью  " + speed + " Мб/сек");
            sleep(volume / speed * 100);
            System.out.println(getName()
                    + "  скачал файл");

            semaphore2.release();
            cdl.countDown();


        } catch (InterruptedException e) {

        }

    }
}
