package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {

    private CountDownLatch cdl;
    private int volume = 500;
    private int speed = 100;


    public Downloaders(String name, CountDownLatch cdl) {
        super(name);

        this.cdl = cdl;

    }

    public void run() {

        try {

            cdl.countDown();
            cdl.await();
            sleep(volume*3 / speed);
            System.out.println(this.getName() + "  встал в очередь на скачивание файла");

            System.out.println(this.getName() +
                    "  скачивает файл со скоростью  " + speed + " Мб/сек");

            System.out.println(this.getName()
                    + "  скачал файл");

        } catch (InterruptedException e) {

        }

    }
}
