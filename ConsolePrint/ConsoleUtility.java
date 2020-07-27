package ConsolePrint;

import Errors.ConsoleClearError;
import Errors.IllegalUserInputException;
import Utilities.LoadDirectory;
import Utilities.PlaySong;
import Utilities.StaticContentProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Utilities.StaticContentProvider.*;

public class ConsoleUtility {
    private static Path configPath = FileSystems.getDefault().getPath("config.txt");
    private static File configFile = new File(configPath.toString());

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

    public static void chooseMenuOption(String opt, List<String> songList) throws ConsoleClearError, IllegalUserInputException {
        switch (opt) {
            case "1":
                validatedPlaySong(songList);
                break;
            case "2":
                listSongs(songList);
                break;
            case "3":
                addDirectory(songList);
                break;
            case "4":
            case "":
                break;
            default:
                printWithoutClear("Wrong option value");
                break;
        }
    }

    public static void defaultAddingDir(List<String> songList) throws ConsoleClearError {
        if (configFile.exists()) {
            String dirPath;
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(configFile.getName())))) {
                dirPath = scanner.nextLine();
                LoadDirectory.importFiles(dirPath, songList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            printWithoutClear(StaticContentProvider.getConfigFileString());
            print(getMenuOptions());
        }
    }

    private static void validatedPlaySong(List<String> songList) throws IllegalUserInputException, ConsoleClearError {
        try {
            printWithoutClear(StaticContentProvider.getSongNumberString());
            int songNumber = Integer.parseInt(retrieveValueFromInput()) - 1;
            PlaySong.playSong(songList.get(songNumber));
            print("Playing " + songList.get(songNumber));
            songOperations();
            printWithoutClear(getMenuOptions());
        } catch (IndexOutOfBoundsException e) {
            printWithoutClear(getPlaySongErrorString());
        }
    }

    private static void songOperations() {
        while(true) {
            try {
                print(getPlayMenuOptions());
                int option = Integer.parseInt(retrieveValueFromInput());
                switch (option) {
                    case 1:
                        PlaySong.resumeSong();
                        break;
                    case 2:
                        PlaySong.pauseSong();
                        break;
                    case 3:
                        PlaySong.repeatSong();
                        break;
                    case 4:
                        PlaySong.stopPlayingSong();
                        break;
                }

                if(option == 4) {
                    break;
                }
            } catch (InterruptedException | IllegalUserInputException | ConsoleClearError e) {
            }
        }
    }

    private static void listSongs(List<String> songList) {
        printWithoutClear(StaticContentProvider.getListString());
        int songNumber = 1;
        for (String song : songList) {
            printWithoutClear(songNumber++ + ": " + song);
        }
    }

    private static void addDirectory(List<String> songList) throws ConsoleClearError, IllegalUserInputException {
        printWithoutClear(StaticContentProvider.getAddDirString());
        LoadDirectory.importFiles(retrieveValueFromInput(), songList);
    }
}
