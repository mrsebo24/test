package pl.test.app;

import pl.test.service.SequenceName;

public class SequenceNameRunner {
    public static void main(String[] args) {

        //task 2
        int[] geometric = {3, 6, 12 ,24, 48};
        int[] arithmetic = {2, 5, 8, 11, 14};
        int[] other = {2, 1, 3, 1, 0};
        System.out.println("SequenceName.getSequenceName(geometric) = " + SequenceName.getSequenceName(geometric));
        System.out.println("SequenceName.getSequenceName(arithmetic) = " + SequenceName.getSequenceName(arithmetic));
        System.out.println("SequenceName.getSequenceName(other) = " + SequenceName.getSequenceName(other));

    }
}
