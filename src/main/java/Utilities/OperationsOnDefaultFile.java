package Utilities;

import Errors.ConsoleAppError;
import Errors.ConsoleClearError;
import Errors.IllegalUserInputException;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static ConsolePrint.ConsoleUtility.*;
import static Utilities.StaticContentProvider.*;

public class OperationsOnDefaultFile {
    private static Path configPath = FileSystems.getDefault().getPath("config.txt");
    private static File configFile = new File(configPath.toString());

    public static void defaultAddingDir(List<String> songList) throws ConsoleClearError, ConsoleAppError {
        if (configFile.exists()) {
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(configFile.getName())))) {
                int pathNumber = selectDefaultPathNumber(scanner);
                selectDefaultPath(songList, pathNumber);
            } catch (IOException | IllegalUserInputException e) {
                throw new ConsoleAppError(e);
            }
        } else {
            createDefaultFile();
        }
    }

    private static void selectDefaultPath(List<String> songList, int pathNumber) throws ConsoleClearError, ConsoleAppError {
        String dirPath;
        Scanner newScanner = null;
        try {
            newScanner = new Scanner(new BufferedReader(new FileReader(configFile.getName())));
            for (int i = 1; i < pathNumber; newScanner.nextLine(), i++) ;
            dirPath = newScanner.nextLine();
            LoadDirectory.importFiles(dirPath, songList);

        } catch (NoSuchElementException | FileNotFoundException e) {
            throw new ConsoleAppError(e);
        } finally {

            if(newScanner == null) {
                newScanner.close();
            }
        }
    }

    private static int selectDefaultPathNumber(Scanner scanner) throws IllegalUserInputException {
        int i = 1;
        while (scanner.hasNextLine()) {
            printWithoutClear(i++ + ": " + scanner.nextLine());
        }

        printWithoutClear(StaticContentProvider.getPathNumber());
        return Integer.parseInt(retrieveValueFromInput());
    }

    private static void createDefaultFile() throws ConsoleAppError {
        try {
            Files.createFile(configPath);
            print(getMenuOptions());
        } catch (IOException | ConsoleClearError e) {
            throw new ConsoleAppError(e);
        }
    }

    public static void reset() throws ConsoleAppError {
        try {
            new FileWriter(configFile, false).close();
            print(getMenuOptions());
        } catch (IOException | ConsoleClearError e) {
            throw new ConsoleAppError(e);
        }
    }

    public static void add() throws ConsoleAppError {
        printWithoutClear(getAddDirString());

        try (BufferedWriter locFile = new BufferedWriter(new FileWriter(configFile, true))) {
            String filePath = retrieveValueFromInput();
            locFile.write(filePath + "\n");
            print(getMenuOptions());
        } catch (IOException | ConsoleClearError | IllegalUserInputException e) {
            throw new ConsoleAppError(e);
        }
    }

    public static void modify() throws ConsoleAppError {
        List<String> paths = new ArrayList<>();

        setPathsList(paths);
        overwriteDefaultFile(paths);
    }

    private static void overwriteDefaultFile(List<String> paths) throws ConsoleAppError {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(configFile, true))) {
            reset();
            for (String path : paths) {
                bufferedWriter.write(path + "\n");
            }
        } catch (IOException e) {
            throw new ConsoleAppError(e);
        }
    }

    private static void setPathsList(List<String> paths) throws ConsoleAppError {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(configFile)))) {
            while (scanner.hasNextLine()) {
                paths.add(scanner.nextLine());
            }

            modifyParticularPath(paths);

        } catch (IOException | IllegalUserInputException e) {
            throw new ConsoleAppError(e);
        }
    }

    private static void modifyParticularPath(List<String> paths) throws IllegalUserInputException, ConsoleAppError {
        int index = selectPathToModify(paths) - 1;
        printWithoutClear(StaticContentProvider.getNewPathString());
        String newPath = retrieveValueFromInput();

        try {
            paths.set(index, newPath);
        } catch (IndexOutOfBoundsException e) {
            printWithoutClear(getWrongIndexValue());
            paths.removeAll(paths);
            setPathsList(paths);
        }
    }

    private static int selectPathToModify(List<String> paths) throws IllegalUserInputException {
        printWithoutClear(StaticContentProvider.getModifyFileString());
        int i = 1;
        for (String path : paths) {
            System.out.println(i++ + ": " + path);
        }
        return Integer.parseInt(retrieveValueFromInput());
    }
}
