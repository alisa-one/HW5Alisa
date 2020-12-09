package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static synchronized void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        CountDownLatch cdl = new CountDownLatch(3);


        new Uploader("Загрузчик", semaphore, cdl).start();

        cdl.countDown();


        for (int i = 1; i < 11; i++) {


            new Downloaders("Скачиватель" + i, cdl).start();


        }

    }


}



