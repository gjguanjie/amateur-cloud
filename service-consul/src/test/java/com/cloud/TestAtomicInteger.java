package com.cloud;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {


    public static void main(String[] args){
        AtomicInteger at = new AtomicInteger();
        System.out.println(at.get());
        System.out.println(at.get());
        at.getAndAdd(1);
        System.out.println(at.get());
        System.out.println(at.getAndAdd(3));
        System.out.println(at.get());
        boolean flag = at.compareAndSet(4,5);
        System.out.println(flag);
        System.out.println(at.get());

    }
}
