import ConsolePrint.ConsoleUtility;
import Errors.ConsoleClearError;
import Errors.IllegalUserInputException;
import Utilities.PlaySong;

import java.util.ArrayList;
import java.util.List;

import static Utilities.StaticContentProvider.getMenuOptions;

public class Main {
    private static List<String> songList = new ArrayList<>();

    public static void main(String[] args) throws ConsoleClearError {
        ConsoleUtility.defaultAddingDir(songList);
        String opt = "";

        while (true) {
            try {
                //printing menu
                ConsoleUtility.print(getMenuOptions());

                ConsoleUtility.chooseMenuOption(opt, songList);

                // listening for options selected by the user
                opt = ConsoleUtility.retrieveValueFromInput();

                if (opt.equals("4")) {
                    PlaySong.stopPlayingSong();
                    break;
                }
                // error handling
            } catch (IllegalUserInputException e) {
                ConsoleUtility.print("Oops something is no yes =(");
            } catch (ConsoleClearError e) {
                break;
            }
        }

        System.exit(1);
    }
}
