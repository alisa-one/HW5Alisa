package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {

    private Semaphore semaphore;
    private CountDownLatch cdl;
    private final int volume = 500;
    private final int speed = 100;



    public Uploader(String name, Semaphore semaphore,CountDownLatch cdl) {
        super(name);
        this.semaphore=semaphore;
        this.cdl=cdl;
    }
    public synchronized void run() {
        try {


            System.out.println(this.getName() + "  готов к работе");

            semaphore.acquire();
            System.out.println("-----------------------------------------");
            for (int p = 1; p < 6; p++) {

                System.out.println(this.getName() + "  загружает часть файла: " + volume/5 + "  Мб "
                        + " со скоростью "
                        + volume / speed + " Мб/сек");

                sleep(volume / speed);}

            System.out.println("  \uD83D\uDFE6 "+"  \uD83D\uDFE6 "+"  \uD83D\uDFE6 "+"  \uD83D\uDFE6 "+"  \uD83D\uDFE6 ");
            System.out.println(this.getName() + " закончил загрузку");

            semaphore.release();


        } catch (InterruptedException e) {

        }
    }
}
