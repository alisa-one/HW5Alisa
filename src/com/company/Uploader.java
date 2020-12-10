package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {


    private CountDownLatch cdl2;
    private int speed = 20;
    private int volume = 500;

    public Uploader(String name, CountDownLatch cdl2) {
        super(name);
        this.cdl2 = cdl2;
    }

    public void run() {

        System.out.println("Загрузчик готов к работе");

        System.out.println(getName() + "  загружает файл  "
                + volume + "  Мб   на сервер "
                + " со скоростью "
                + speed + " Мб/сек");

        System.out.println("Загрузилось на сервер:   " + volume + " Мб ");
        System.out.println("\uD83D\uDFE6" + "\uD83D\uDFE6" + "\uD83D\uDFE6"
                + "\uD83D\uDFE6" + "\uD83D\uDFE6");
        System.out.println(getName() + " закончил загрузку");

        try {
            sleep(volume / speed * 100);
        } catch (InterruptedException e) {

        }
        cdl2.countDown();

    }
}
