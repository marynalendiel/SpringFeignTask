package com.example.springboottask.service;

/*
input:
"form", "abc", "form", "bca","qwer", "cab", "wreq"

output:
"form", "form", ,
"abc", "bca","cab"
"qwer", "wreq"
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTask {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("form");
        list.add("abc");
        list.add("form");
        list.add("bca");
        list.add("qwer");
        list.add("cab");
        list.add("wreq");

        // loop
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String el : list) {
            char[] a = el.toCharArray();
            Arrays.sort(a);
            if (map.containsKey(String.valueOf(a))) {
                List<String> l = new ArrayList<>(map.get(String.valueOf(a)));
                l.add(el);
                map.put(String.valueOf(a), l);
            }
            else {
                map.put(String.valueOf(a), Collections.singletonList(el));
            }
        }

        for (Map.Entry<String, List<String>> el : map.entrySet()) {
            System.out.println(el.getValue());
        }
        System.out.println(map);

        // stream
        map = list.stream()
                .collect(Collectors.groupingBy(el -> {
                    char[] a = el.toCharArray();
                    Arrays.sort(a);
                    return String.valueOf(a);}));

        for (Map.Entry<String, List<String>> el : map.entrySet()) {
            System.out.println(el.getValue());
        }
        System.out.println(map);
    }


}
