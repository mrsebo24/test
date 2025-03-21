package pl.test.service;
//klasa narzedziowa to samo podejscie zastosowalem co w SuperPrimes
public class LineReport {

    private LineReport() {
    }

    public static void lineReportFromFile(String line) {
        String[] lineFromFile = line.split(" ");
        int[] numbers = new int[lineFromFile.length];
        for (int i = 0; i < lineFromFile.length; i++) {
            numbers[i] = Integer.parseInt(lineFromFile[i]);
        }

        String monotonicity = checkMonotonicity(numbers);
        int minNumberFromArray = getMinNumberFromArray(numbers);
        int maxNumberFromArray = getMaxNumberFromArray(numbers);
        int mostPopularNumberFromArrayNumbers = getMostPopularNumberFromArrayNumbers(numbers);
        boolean b = checkIfBetweenNumbersIsAllNaturalNumbers(numbers);

        System.out.println("Report from line: " + line);
        System.out.println("Monotonicity: " + monotonicity);
        System.out.println("Minimum number: " + minNumberFromArray);
        System.out.println("Maximum number: " + maxNumberFromArray);
        System.out.println("Most popular number: " + mostPopularNumberFromArrayNumbers);
        System.out.println("Between min and max number are: " + (b ? "all natural numbers" : "not all natural numbers"));
    }


    //okreslic monotonicznosc ciagu
    private static String checkMonotonicity(int[] arrayNumbers) {
        String result = "BRAK MONOTONICZNOSCI";
        boolean increasing = true;
        boolean decreasing = true;
        boolean nonIncreasing = true;
        boolean nonDecreasing = true;
        boolean constant = true;
        //najpierw stwierdzilem ze sprawdze wdlug mnie najlatwiejsze warunki
        for (int i = 0; i < arrayNumbers.length - 1; i++) {
            if (!(arrayNumbers[i] < arrayNumbers[i + 1])) increasing = false;
            if (!(arrayNumbers[i] > arrayNumbers[i + 1])) decreasing = false;
            if (arrayNumbers[i] != arrayNumbers[i + 1]) constant = false;
        }
        // w drugim etapie gdy wszystkie warunki sa na false moge sprawdzic warunki nierosnacy i niemalejacy
        if (!increasing && !decreasing && !constant) {
            for (int i = 0; i < arrayNumbers.length - 1; i++) {
                if (!(arrayNumbers[i] >= arrayNumbers[i + 1])) nonIncreasing = false;
                if (!(arrayNumbers[i] <= arrayNumbers[i + 1])) nonDecreasing = false;
            }
            //po wykonaniu petli sprawdzam czy ktorys z warunkow jest true
            if (nonIncreasing) result = "NIEROSNACY";
            if (nonDecreasing) result = "NIEMALEJACY";
        }

        if (increasing) result = "ROSNACE";
        if (decreasing) result = "MALEJACE";
        if (constant) result = "STALY";
        //jesli wsszystkie warunki sa na false zwracam 'brak monotonicznosci'
        return result;
    }

    //znalezc maxa
    private static int getMaxNumberFromArray(int[] arrayNumbers) {
        int max = Integer.MIN_VALUE;

        for (int arrayNumber : arrayNumbers) {
            max = Math.max(max, arrayNumber);
        }
        return max;
    }
    //znalezc min
    private static int getMinNumberFromArray(int[] arrayNumbers) {
        int min = Integer.MAX_VALUE;

        for (int arrayNumber : arrayNumbers) {
            min = Math.min(min, arrayNumber);
        }
        return min;
    }

    //znalezc najpopularnijesza liczbe
    private static int getMostPopularNumberFromArrayNumbers(int[] arrayNumbers) {
        int maxCount = 0;
        int mostPopularNumber = 0;

        for (int arrayNumber : arrayNumbers) {
            int count = 0;
            for (int number : arrayNumbers) {
                if (arrayNumber == number) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostPopularNumber = arrayNumber;
            }
        }
        return mostPopularNumber;
    }

    //stwierdzic czy miedzy min i max znajduja sie wszystkie mozliwe liczby naturalne.
    private static boolean checkIfBetweenNumbersIsAllNaturalNumbers(int[] arrayNumbers) {
        if (arrayNumbers.length == 0) return false;
        //skorzystalem z metod ktore napisalem by znalezc min i max z ciagu
        int minNumberFromArray = getMinNumberFromArray(arrayNumbers);
        int maxNumberFromArray = getMaxNumberFromArray(arrayNumbers);

        //tworze tablice boolean i przechodze po tablicy przy pomocy petli for i sprawdzam warunkiem czy podana liczba
        //miesci sie w wymaganiach
        boolean[] present = new boolean[maxNumberFromArray - minNumberFromArray + 1];
        for (int arrayNumber : arrayNumbers) {
            if (arrayNumber >= minNumberFromArray && arrayNumber <= maxNumberFromArray) {
                present[arrayNumber - minNumberFromArray] = true;
            }
        }
        //przechodze po tablicy z petla for i sprawdzam czy jest jakis false jesli jest to uzywam negacji i zwracam false(czyli ze danej liczby nie ma)
        for (boolean exists : present) {
            if (!exists) return false;
        }

        return true;
    }
}
