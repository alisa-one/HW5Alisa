package com.company.CountDownLatch;

import java.util.concurrent.Semaphore;

public class Uploader extends Thread {


    private Semaphore semaphore;
    private int volume = 500;
    private int speed = 100;


    public Uploader(String name, Semaphore semaphore) {
        super(name);
        this.semaphore=semaphore;


    }

    public synchronized void run() {
        try {


            System.out.println(this.getName() + "  готов к работе");

            semaphore.acquire();
            for (int p = 1; p < 5; p++) {



                System.out.println(this.getName() + "  загружает часть файла: " + volume/p + "  Мб "
                        + " со скоростью "
                        + volume / speed + " Мб/сек");
                System.out.println("  \uD83D\uDFE6 ");

                sleep(volume / speed/p);}

            System.out.println(this.getName() + " закончил загрузку");

            semaphore.release();

        } catch (InterruptedException e) {

        }
    }
}
