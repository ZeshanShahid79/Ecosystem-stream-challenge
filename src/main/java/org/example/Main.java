package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 7, 6, 3, 2, 7, 8, 9);

        // Schritt 1 gerade Zahlen
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("---------------------------------------");


        // Schritt 2 verdopple jede zahl
        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);
        System.out.println("---------------------------------------");


        // Schritt 3 sort by order

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
        // Schritt 4 Summer aller Elemente

        Optional number = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(number.get());
        System.out.println("---------------------------------------");

        // Schritt 5
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("---------------------------------------");

        // Schritt 6
        List<Integer> noDoubles = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(noDoubles);
        System.out.println("---------------------------------------");


        // Bonus Aufgabe

        List<Student> studentList = Files.lines(Path.of("src/main/resources/students.csv"))
                .skip(1)
                .filter(line -> !line.isEmpty())
                .distinct()
                .map(line -> {
                    String[] split = line.split(",", 4);
                    return new Student(split[0], split[1], split[2], split[3]);
                })
                .toList();

        System.out.println(studentList);

    }
}