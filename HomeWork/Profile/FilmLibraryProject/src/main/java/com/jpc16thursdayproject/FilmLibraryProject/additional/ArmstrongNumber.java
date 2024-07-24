package com.jpc16thursdayproject.FilmLibraryProject.additional;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Integer[] armstrongNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153,
                360, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
                548834, 1746725, 4210818, 9800817, 9996315, 24678050,
                24678051, 88598477, 146511208, 472335975, 534494836, 912985153};
        for (Integer i : armstrongNumbers) {
            System.out.println("Число " + i +
                    (checkNumber(i) ? " является числом Армстронга" : " не является числом Армстронга"));
        }
    }

    public static boolean checkNumber(int number) {
        return IntStream.iterate(number, i -> i / 10)
                .limit(String.valueOf(number).length())
                .map(i -> (int) Math.pow(i % 10, String.valueOf(number).length()))
                .sum() == number;
    }

}

