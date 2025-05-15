package org.example;

import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

public class ExStream {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> lista = rand.ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista: " + lista);

        int suma = lista.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);

        int max = lista.stream().max(Comparator.naturalOrder()).orElseThrow();
        int min = lista.stream().min(Comparator.naturalOrder()).orElseThrow();
        System.out.println("Maximul: " + max);
        System.out.println("Minimul: " + min);

        List<Integer> filtrate = lista.stream()
                .filter(x -> x >= 10 && x <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente în [10, 20]: " + filtrate);

        List<Double> listaDouble = lista.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println("Listă Double: " + listaDouble);

        boolean contine12 = lista.stream().anyMatch(x -> x == 12);
        System.out.println("Lista conține 12? " + contine12);
    }
}
