package pl.test.app;

import pl.test.service.SuperPrimes;

import java.util.Arrays;

public class SuperPrimeRunner {
    public static void main(String[] args) {


        int[] ints = SuperPrimes.superPrimes(50, 100);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}
