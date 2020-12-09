package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {


    private CountDownLatch cdl;

    private int speed = 100;
    private int volume = 500;


    public Uploader(String name, CountDownLatch cdl) {
        super(name);

        this.cdl = cdl;

    }


    public synchronized void run() {
        try {

            System.out.println(this.getName() + "  загружает файл на сервер " + volume + "  Мб "
                    + " со скоростью "
                    + speed + " Мб/сек");

            sleep(volume / speed);

            System.out.println("Загрузилось на сервер:   " + volume + " Мб ");


            System.out.println("  \uD83D\uDFE6 " + "  \uD83D\uDFE6 " + "  \uD83D\uDFE6 " + "  \uD83D\uDFE6 " + "  \uD83D\uDFE6 ");
            System.out.println(this.getName() + " закончил загрузку");
            cdl.countDown();

        } catch (InterruptedException e) {

        }

    }
}
