package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {

    private Semaphore semaphore;
    private CountDownLatch cdl;

    private int speed = 20;
    private int volume = 500;


    public Uploader(String name, Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;

    }


    public synchronized void run() {
        try {
            System.out.println("Загрузчик готов к работе");
            semaphore.acquire();
            System.out.println(this.getName() + "  загружает файл  " + volume + "  Мб   на сервер "
                    + " со скоростью "
                    + speed + " Мб/сек");



            System.out.println("Загрузилось на сервер:   " + volume + " Мб ");


            System.out.println("\uD83D\uDFE6" + "\uD83D\uDFE6" + "\uD83D\uDFE6" + "\uD83D\uDFE6" + "\uD83D\uDFE6");
            System.out.println(this.getName() + " закончил загрузку");
            semaphore.release();
            cdl.countDown();

        } catch (InterruptedException e) {

        }

    }
}
