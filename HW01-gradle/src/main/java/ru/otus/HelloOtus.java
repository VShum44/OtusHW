package ru.otus;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;


public class HelloOtus {
    public static void main(String... args) {
        List<String> wordsJava = Lists.newArrayList("I ","Love ","Java ");
        Set<String> wordsOtus = Sets.newHashSet("And ","Otus");
        Iterable<String> concat = Iterables.concat(wordsJava,wordsOtus);

        concat.forEach(System.out::print);
    }
}
