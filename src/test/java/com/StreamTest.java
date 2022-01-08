package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("c");
        list.add("d");
        list.add("d");
//        System.out.println(list);
//
//        list.stream().forEach(l -> {
//            System.out.println("输出" + l);
//        });
//
//        List<String> list1 = list.stream().distinct().collect(Collectors.toList());
//        Map<String , Object> map = list.stream().distinct().collect(Collectors.toMap(i -> i, a->a));
//        System.out.println(list1);
//        System.out.println(map);

        // 向改变每一个list中元素的内容
        List<String> list1 = list.stream().map(i -> i + "a").collect(Collectors.toList());


        
        System.out.println(list1);
    }
}
