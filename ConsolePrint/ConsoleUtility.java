package ConsolePrint;

import Errors.ConsoleClearError;
import Errors.IllegalUserInputException;
import Utilities.LoadDirectory;
import Utilities.StaticContentProvider;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleUtility {

    public static void print(String... outputs) throws ConsoleClearError {
        clearConsole();
        printWithoutClear(outputs);
    }

    public static void printWithoutClear(String... outputs) {
        for (String output : outputs) {
            System.out.println(output);
        }
    }

    public static void clearConsole() throws ConsoleClearError {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            throw new ConsoleClearError();
        }
    }

    public static String retrieveValueFromInput() throws IllegalUserInputException {
        Scanner scanner = new Scanner(System.in);
        try {
           return scanner.nextLine();
        } catch (IllegalStateException | NoSuchElementException e) {
            throw new IllegalUserInputException("Bad input");
        }
    }

    public static void chooseMenuOption(String opt, List<String> songList) throws ConsoleClearError, IOException, IllegalUserInputException {
        switch (opt) {
            case "1":
                printWithoutClear("Play song");
                break;
            case "2":
                printWithoutClear("", "", "List songs:", "", "");
                for (String song : songList) {
                    printWithoutClear(song);
                }
                break;
            case "3":
                printWithoutClear(StaticContentProvider.getListString());
                LoadDirectory.importFiles(retrieveValueFromInput(), songList);
                break;
            case "4":
                break;
            default:
                printWithoutClear("Wrong option value");
                break;
        }
    }
}
