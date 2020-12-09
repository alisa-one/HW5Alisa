package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private Semaphore semaphore;
    private CountDownLatch cdl;
    private int volume = 500;
    private int speed = 100;



    public Downloaders(String name, CountDownLatch cdl) {
        super(name);
        this.cdl=cdl;

    }
    public  void run() {


        try {

            cdl.countDown();
            cdl.await();
            System.out.println( this.getName() + "  зарегистрировался " +
                    " и встал в очередь на загрузку ");


            System.out.println( this.getName() +
                    "  скачивает файл со скоростью  " + speed + " Мб/сек");



            System.out.println( this.getName()
                    + "  скачал за  " + volume / speed + "  секунд");
            sleep(volume / speed);

        } catch (InterruptedException e) {

        }

    }
}
