package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    private static CountDownLatch cdl2;

    public static synchronized void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        CountDownLatch cdl= new CountDownLatch(3);
        CountDownLatch cdl2 = new CountDownLatch(10);

        new Uploader("Загрузчик", semaphore, cdl2).start();

        for (int i = 1; i < 11; i++) {

            new Downloaders("Скачиватель " + i,semaphore, cdl, cdl2).start();


        }


    }
}




