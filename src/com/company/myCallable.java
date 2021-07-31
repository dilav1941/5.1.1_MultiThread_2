package com.company;

import java.util.concurrent.Callable;

public class myCallable implements Callable<Integer> {
    private int massegeCount = 0;

    public myCallable(int massegeCount){
        this.massegeCount = massegeCount;
    }

    @Override
    public Integer call() throws Exception{
        int showCount = 0;
        for(int i = 0; i < massegeCount; i++){
            Thread.sleep (2000);
            System.out.printf ( "Добрый день! Работает Поток №%s \n", Thread.currentThread ().getId ());
            showCount++;
        }
        return showCount;
    }
}
