package com.company;


import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        int count = 0;
        List<myCallable> callableList = new ArrayList<> ();

        callableList.add (new myCallable (1));
        callableList.add (new myCallable (2));
        callableList.add (new myCallable (3));
        callableList.add (new myCallable (4));

        ExecutorService threadPool = Executors.newFixedThreadPool (Runtime.getRuntime ().availableProcessors ());

        System.out.println ("Запуск - invoking all");

        final List<Future<Integer>> taskAll = threadPool.invokeAll (callableList);
        for (Future<Integer> task : taskAll) {
            count += task.get ();
        }
        System.out.println ("Отправлено сообщений: " + count); // колличество запусков потока

        System.out.println ("Запуск invoking any");

        int result = threadPool.invokeAny (callableList);

        System.out.println ("Отправлено сообщений: " + result);

        threadPool.shutdown ();
    }
}
