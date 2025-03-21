package pl.test.app;

import pl.test.service.LineReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineReportRunner {
    public static void main(String[] args) {

        //odczytywanie linii i co wykonanie zdany raport
        try (
               Scanner scanner = new Scanner(new File("liczby.txt"))
        ) {
            while (scanner.hasNextLine()) {
                LineReport.lineReportFromFile(scanner.nextLine());
                System.out.println("--------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

