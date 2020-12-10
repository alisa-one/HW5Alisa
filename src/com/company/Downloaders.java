package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private Semaphore semaphore;
    private CountDownLatch cdl;
    private CountDownLatch cdl2;

    private int volume = 500;
    private int speed = 100;


    public Downloaders(String name, Semaphore semaphore,CountDownLatch cdl, CountDownLatch cdl2) {
        super(name);
        this.semaphore=semaphore;
        this.cdl = cdl;
        this.cdl2=cdl2;
    }
    public synchronized void run() {
        try {
            cdl2.countDown();
            cdl2.await();

            semaphore.acquire(3);
            System.out.println(this.getName() +
                    "  скачивает файл со скоростью  " + speed + " Мб/сек");
            sleep(volume/ speed);

            System.out.println(this.getName()
                    + "  скачал файл");
            semaphore.release(3);
            cdl.countDown();

        } catch (InterruptedException  IllegalThreadStateException ) {

        }

    }
}
