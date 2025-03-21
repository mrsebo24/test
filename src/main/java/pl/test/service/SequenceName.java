package pl.test.service;

public class SequenceName {

    private SequenceName() {
    }

    public static String getSequenceName(int[] sequence) {
        String result = "INNY";

        if (isArithmetic(sequence)) {
            result = "ARYTMETYCZNY";
        }
        if (isGeometric(sequence)) {
            result = "GEOMETRYCZNY";
        }
        return result;
    }

    //dodalem oddzielne metody do sprawdzenia kazdego warunku, wydaje mi sie ze to lepiej wyglada + glowna metoda nie jest "dluga".

    public static boolean isArithmetic(int[] sequence) {
        boolean isArithmetic = false;
        int index = 1;
        int difference = Math.abs(sequence[0] - sequence[1]);

        for (int i : sequence) {
            if (index == sequence.length) {
                break;
            } else {
                if (Math.abs(i - sequence[index++]) != difference) {
                    isArithmetic = false;
                    break;
                } else {
                    isArithmetic = true;
                }
            }
        }
        return isArithmetic;
    }
    private static boolean isGeometric(int[] sequence) {
        boolean isGeometric = false;
        int index = 1;
        int difference = sequence[1] / sequence[0];
        for (int i : sequence) {
            if (index == sequence.length) {
                break;
            } else {
                if (sequence[index++] / i != difference) {
                    isGeometric = false;
                    break;
                } else {
                    isGeometric = true;
                }
            }
        }
        return isGeometric;
    }
}
