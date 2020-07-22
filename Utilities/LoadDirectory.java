package Utilities;

import ConsolePrint.ConsoleUtility;
import Errors.ConsoleClearError;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoadDirectory {

    public static void importFiles(String dirPath, List<String> songList) throws ConsoleClearError {
        Path path = Paths.get(dirPath);
        if (songList != null && !songList.isEmpty()) {
            songList.removeAll(songList);
        }

        if (Files.exists(path)) {
            File file = new File(dirPath);
            readFolder(file, songList);

            if (songList.isEmpty()) {
                ConsoleUtility.print("No mp3 files");
            }
        } else {
            ConsoleUtility.print("There is no such a folder");
        }
    }

    private static void readFolder(File file, List<String> songList) {
        for (File folderFile : file.listFiles()) {
            if (folderFile.isDirectory()) {
                readFolder(folderFile, songList);
            } else {
                String fileExtension = folderFile.getName().substring(folderFile.getName().length() - 4);
                if (fileExtension.equals(".mp3")) {
                    songList.add(folderFile.getAbsolutePath());
                }
            }
        }
    }
}
