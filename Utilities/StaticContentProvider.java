package Utilities;

public class StaticContentProvider {

    private static String top0 = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String top1 = "XXXXXXXXXX MP3 console APP XXXXXXXXXX";
    private static String top2 = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String menuLabel = "XXXXXXXXXXX     -MENU-    XXXXXXXXXXX";
    private static String menuOpt1 = "1 -Play song";
    private static String menuOpt2 = "2 - Show the songs list";
    private static String menuOpt3 = "3 - Add a directory";
    private static String menuOpt4 = "4 - Shutdown the app";
    private static String addDirString = "\nEnter a directory path:\n";
    private static String listString = "\nList songs:\n";


    public static String[] getMenuOptions() {
        return new String[]{top0, top1, top2, menuLabel, menuOpt1, menuOpt2, menuOpt3, menuOpt4};
    }

    public static String getAddDirString() {
        return addDirString;
    }

    public static String getListString() {
        return listString;
    }
}
