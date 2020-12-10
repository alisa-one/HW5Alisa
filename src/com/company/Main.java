package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    private static CountDownLatch cdl2;

    public static synchronized void main(String[] args) {

        Semaphore semaphore2 = new Semaphore(3, true);

        CountDownLatch cdl = new CountDownLatch(10);
        CountDownLatch cdl2 = new CountDownLatch(1);

        new Uploader("Загрузчик", cdl2).start();

        for (int i = 1; i < 11; i++) {
            new Downloaders("Скачиватель " + i, semaphore2, cdl, cdl2).start();
        }

        try {
            cdl.await();
            System.out.println("Файл удален из сервера!");
        } catch (InterruptedException e) {

        }


    }
}




