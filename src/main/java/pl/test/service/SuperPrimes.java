package pl.test.service;
//wydaje mi sie ze w przypadku tej metody i jej pomniejszych metod nie jest zlym pomyslem by umiescic je w klasie narzedziowej
//nie zasmiecamy wtedy main i jedynie wywolujemy tam metode
public class SuperPrimes {

    private SuperPrimes() {
    }

    public static int[] superPrimes(int from, int to) {

        int[] arrayOfNumbers = new int[to];
        for (int i = 0; i < arrayOfNumbers.length - (from - 1); i++) {
            arrayOfNumbers[i] = from + i;
        }

        int counter = getCounter(arrayOfNumbers);

        int[] superPrimesNumbers = new int[counter];

        int index = 0;
        for (int arrayOfNumber : arrayOfNumbers) {
            if (isPrime(arrayOfNumber)) {
                superPrimesNumbers[index++] = arrayOfNumber;
            }
        }
        return superPrimesNumbers;
    }

    //sprawdzam ile liczb jest super liczbami by potem zwrocic int ktorego uzyje do okreslienia pojemnosci tablicy ktora
    //potem zostanie zapelniona tymi liczbami i zwrocona
    private static int getCounter(int[] arrayOfNumbers) {
        int counter = 0;
        for (int arrayOfNumber : arrayOfNumbers) {
            if (isPrime(arrayOfNumber)) {
                counter++;
            }
        }
        return counter;
    }

    //sprawdzam czy jest to super liczba
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
