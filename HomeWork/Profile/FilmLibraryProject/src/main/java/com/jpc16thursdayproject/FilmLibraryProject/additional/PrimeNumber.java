package com.jpc16thursdayproject.FilmLibraryProject.additional;

import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 58, 62, 67, 71, 73, 79, 83, 89, 97, 101,
                103, 106, 109, 113, 127, 131, 137, 139, 149, 150, 157, 163,
                167, 173, 179, 181, 191, 192, 187, 199};
        for (Integer i : numbers) {
            System.out.println("Число " + i +
                    (checkNumber(i) ? " является простым числом" : " не является простым числом"));
        }
    }

    public static boolean checkNumber(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .count() == 2;
    }

}

