package pl.test.app;

import pl.test.service.SequenceName;

public class IsArithmeticRunner {
    public static void main(String[] args) {
        //metode isArithmetic pozyczylem z klasy SequenceName

        int[] sequence = {2, 5, 8, 11, 14};
        System.out.println("SequenceName.isArithmetic(sequence) = " + SequenceName.isArithmetic(sequence));
    }
}
