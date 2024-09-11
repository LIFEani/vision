package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args){

        Calendar t1 = Calendar.getInstance();
        t1.setTime(new Date());
        //30min前
        t1.add(Calendar.MINUTE, -30);

        Calendar t2 = Calendar.getInstance();
        t2.setTime(new Date());

        System.out.println(t1.getTime());
        System.out.println(t2.getTime());
    }
}









