package com.fd.question02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/27 0027 下午 19:03
 */
public class Demo {
    public static void main(String[] args) {
        String target = "a";
        List<String> list = new ArrayList<>(10);
        list.add("abc");
        list.add("dba");
        list.add("jxx");
        list.add("xa");

        System.out.println("count = " + find(target, list));
        ;
    }

    private static int find(String target, List<String> list) {
        int count = 0;
        if (target == null) {
            return -1;
        }
        if (Objects.nonNull(list) && !list.isEmpty()) {
            for (String element : list) {
                if (element.contains(target)) {
                    count++;
                }
            }
        }
        return count;
    }
}
