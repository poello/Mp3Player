package Utilities;

public class StaticContentProvider {

    private static String top0 = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String top1 = "XXXXXXXXXX MP3 console APP XXXXXXXXXX";
    private static String top2 = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String menuLabel = "XXXXXXXXXXX     -MENU-    XXXXXXXXXXX";
    private static String menuOpt1 = "1 - Play song";
    private static String menuOpt2 = "2 - Show the songs list";
    private static String menuOpt3 = "3 - Add a directory";
    private static String menuOpt4 = "4 - Operate on the default file";
    private static String menuOpt5 = "5 - Shutdown the app";
    private static String addDirString = "\nEnter a directory path:\n";
    private static String listString = "\nList songs:\n";
    private static String playSongErrorString = "Add a directory first / Enter a proper song number";
    private static String configFileString = "Problem with file import. Config file doesn't exists";
    private static String songNumberString = "\nEnter a song number:\n";
    private static String interfaceLabel = "\nChoose option:";
    private static String playOpt1 = "1 - Play";
    private static String playOpt2 = "2 - Pause";
    private static String playOpt3 = "3 - Repeat";
    private static String playOpt4 = "4 - Stop\n";
    private static String emptyFileString = "File is empty\n";
    private static String modifyFileString = "Select a path to modify: ";
    private static String newPathString = "Enter a new path: ";
    private static String wrongIndexValue = "Wrong index value";
    private static String fileOpt1 = "1 - Reset file content";
    private static String fileOpt2 = "2 - Add default path to the file";
    private static String fileOpt3 = "3 - Modify file content";
    private static String pathNumber = "Choose a file path to load: \n";

    public static String[] getMenuOptions() {
        return new String[]{top0, top1, top2, menuLabel, menuOpt1, menuOpt2, menuOpt3, menuOpt4, menuOpt5};
    }

    public static String getAddDirString() {
        return addDirString;
    }

    public static String getListString() {
        return listString;
    }

    public static String getPlaySongErrorString() {
        return playSongErrorString;
    }

    public static String getConfigFileString() {
        return configFileString;
    }

    public static String getSongNumberString() {
        return songNumberString;
    }

    public static String[] getPlayMenuOptions() {
        return new String[]{interfaceLabel, playOpt1, playOpt2, playOpt3, playOpt4};
    }

    public static String[] getDefaultFileOperationsMenu() {
        return new String[]{interfaceLabel, fileOpt1, fileOpt2, fileOpt3};
    }

    public static String getEmptyFileString() {
        return emptyFileString;
    }

    public static String getModifyFileString() {
        return modifyFileString;
    }

    public static String getNewPathString() {
        return newPathString;
    }

    public static String getWrongIndexValue() {
        return wrongIndexValue;
    }

    public static String getPathNumber() {
        return pathNumber;
    }
}
