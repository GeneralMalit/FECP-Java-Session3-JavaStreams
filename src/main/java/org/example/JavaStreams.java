package org.example;

import java.sql.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaStreams {
    public static void main(String[] args) {

        System.out.println("Quiz 1 - Java Streams: Basic Functional Programming\n\n");
        //ACTIVITY 1
        System.out.println("Activity 1: Filter Odd Numbers");
        List<Integer> initializedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers = new ArrayList<>(initializedNumbers);
        Predicate<Integer> isOdd = num -> num % 2 == 1;

        List<Integer> oddNumbers =  numbers.stream().filter(isOdd).collect(Collectors.toList());

        System.out.printf("Odd numbers: %s\n\n", oddNumbers.toString());

        //ACTIVITY 2
        System.out.println("Activity 2: Filter Strings Starting with 'A'");
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian"));
        Predicate<String> startsWithA = (name) -> {
            return name.startsWith("A");
        };
        List<String> namesStartingWithA = names.stream().filter(startsWithA).collect(Collectors.toList());
        System.out.printf("Names starting with A: %s\n\n", namesStartingWithA.toString());

        //ACTIVITY 3
        System.out.println("Activity 3: Square all Numbers");
        List<Integer> numbersToSquare = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> squared = numbersToSquare.stream().map(x -> Math.pow(x, 2)).map(x -> (int) Math.round(x)).collect(Collectors.toList());
        System.out.printf("Squared numbers: %s\n\n" , squared.toString());

        //ACTIVITY 4
        System.out.println("Activity 4: Combine Predicates");
        //numbers will be reused from activity 1 (same 1 - 10 range)
        Predicate<Integer> isEven = (num) -> {
            return num % 2 == 0;
        };
        Predicate<Integer> isGreaterThanFive = (num) -> {
          return num > 5;
        };
        Predicate<Integer> combinedPredicate = isEven.and(isGreaterThanFive);
        List<Integer> evenAndGreaterThanFive = numbers.stream().filter(combinedPredicate).collect(Collectors.toList());
        System.out.printf("Even and >5: %s\n\n" , evenAndGreaterThanFive.toString());

        //ACTIVITY 5
        System.out.println("Activity 5: Sort Objects Using Comparator");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Priya Singh", 29));
        people.add(new Person("Javier Mendoza", 41));
        people.add(new Person("Anika Johnson", 22));
        people.add(new Person("Kenji Nakamura", 55));
        people.add(new Person("Fatima Khan", 36));


        Comparator<Person> byAgeAscending = Comparator.comparingInt(Person::getAge);
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Comparator<Person> byAgeDescending = Comparator.comparingInt(Person::getAge).reversed();



        System.out.println("Sorted by age (ascending):");
        people.sort(byAgeAscending);
        for(Person person: people){
            System.out.println(person.toString());
        }
        System.out.println("\n");
        System.out.println("Sorted by name:");
        people.sort(byName);
        for(Person person: people){
            System.out.println(person.toString());
        }

        System.out.println("\n");
        System.out.println("Sorted by age (descending):");
        people.sort(byAgeDescending);
        for(Person person: people){
            System.out.println(person.toString());
        }
    }
}