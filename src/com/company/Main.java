package com.company;

import java.util.*;

public class Main {

    public static Map<String, List<Map<String, Integer>>> map = new HashMap<>();

    public static void main(String[] args) {

        add("10104364-21", "50101004-22", 18);
        add("10104364-21", "50101003-22", 18);
        add("10104362-21", "50101002-22", 18);
        add("10104361-21", "50101003-22", 18);
        add("10104364-21", "50101004-22", 18);


        System.out.println(map);

    }

    public static void show(String monolotto, String lotto, Integer qty) {
        System.out.printf("Monolotto: %s, Lotto: %s, Qty: %d .\n", monolotto,lotto,qty);
    }

    public static void add(String monolotto, String lotto, Integer qty) {
        if(monolotto.isEmpty())
            return;
        if(lotto.isEmpty())
            return;

        List<Map<String, Integer>> tempList = new ArrayList<>();
        Map<String, Integer> tempMap = new HashMap<>();
        tempMap.put(lotto, qty);
        tempList.add(tempMap);

        if(map.containsKey(monolotto)) {
            if(map.get(monolotto).contains(tempMap)) {
                int indexOfLotto = map.get(monolotto).indexOf(tempMap);
                map.get(monolotto).get(indexOfLotto).put(lotto, map.get(monolotto).get(indexOfLotto).get(lotto) + qty);
            } else {
                map.get(monolotto).add(tempMap);
            }
        } else {
            map.put(monolotto, tempList);
        }

    }

}


