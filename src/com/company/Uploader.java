package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {

    private Semaphore semaphore;
    private CountDownLatch cdl2;
    private int speed = 20;
    private int volume = 500;
    public Uploader(String name, Semaphore semaphore, CountDownLatch cdl2) {
        super(name);
        this.semaphore = semaphore;
        this.cdl2 = cdl2;   }
    public synchronized void run() {
        try {
            System.out.println("Загрузчик готов к работе");
            semaphore.acquire(10);
            System.out.println(this.getName() + "  загружает файл  "
                    + volume + "  Мб   на сервер "
                    + " со скоростью "
                    + speed + " Мб/сек");
            sleep(volume/speed);
            System.out.println("Загрузилось на сервер:   " + volume + " Мб ");
            System.out.println("\uD83D\uDFE6" + "\uD83D\uDFE6" + "\uD83D\uDFE6"
                    + "\uD83D\uDFE6" + "\uD83D\uDFE6");
            System.out.println(this.getName() + " закончил загрузку");
            semaphore.release(10);

            cdl2.countDown();

        } catch (InterruptedException e) {

        }

    }
}
