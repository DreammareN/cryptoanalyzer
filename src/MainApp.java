import constants.AppConstants;
import menu.AppMenu;
import service.CipherService;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String fromConsole;
        AppMenu menu = new AppMenu();
        System.out.println(AppConstants.GREETING);

        while(true) {
            System.out.println(AppConstants.WHAT_DO_YOU_WANT);
            System.out.println(AppConstants.OPTION_MENU_ENCRYPT);
            System.out.println(AppConstants.OPTION_MENU_DECRYPT);
            System.out.println(AppConstants.OPTION_MENU_BRUTE_FORCE);
            System.out.println(AppConstants.OPTION_MENU_EXIT);
            System.out.println(AppConstants.WRITE_YOUR_ACTION);

            fromConsole = scan.nextLine();
            switch (fromConsole) {
                case "1": {
                    menu.menuOption('+');
                    break;
                }
                case "2": {
                    menu.menuOption('-');
                    break;
                }
                case "3": {
                    menu.menuOption('b');
                    break;
                }
                case "0": {
                    menu.menuOptionExit();
                    return;
                }
                default: {
                    menu.menuOptionNotFoundOption();
                    break;
                }
            }

        }

    }
}