package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {


    public static synchronized void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);


        for (int i = 1; i < 3; i++) {
            new Uploader("Загрузчик" + i, semaphore).start();

        }


        System.out.println("-----------------------------------------");

        CountDownLatch cdl = new CountDownLatch(3);

        for (int i = 1; i < 11; i++) {


            new Downloaders("Скачиватель" + i, cdl).start();


        }
        System.out.println ("Файл удален с сервера");
    }


}



