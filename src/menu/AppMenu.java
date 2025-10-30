package menu;

import constants.AppConstants;
import service.CipherService;

import java.io.IOException;
import java.util.Scanner;

public class AppMenu {

    public void menuOption (char operation) throws IOException {
        String path, keyFromConsole;
        CipherService cipherService = new CipherService();
        if (operation == '+') {
            System.out.println(AppConstants.ENCRYPT_TEXT);
            path = menuOptionFindFile(AppConstants.WRITE_PATH_TO_FILE_TO_ENCRYPT);
        } else if (operation == '-') {
            System.out.println(AppConstants.DECRYPT_TEXT);
            path = menuOptionFindFile(AppConstants.WRITE_PATH_TO_FILE_TO_DECRYPT);
        } else {
            System.out.println(AppConstants.BRUTE_FORCE_TEXT);
            path = menuOptionFindFile(AppConstants.WRITE_PATH_TO_FILE_FOR_BRUTE_FORCE);
        }

        if (!path.equals("exit")) {
            if (operation == 'b') {
                System.out.println(cipherService.fileBruteForce(path));
            } else {
                if (operation == '+') {
                    keyFromConsole = menuOptionCheckKey(AppConstants.WRITE_KEY_FOR_ENCRYPT);
                } else {
                    keyFromConsole = menuOptionCheckKey(AppConstants.WRITE_KEY_FOR_DECRYPT);
                }
                if (!keyFromConsole.equals("exit")) {
                    System.out.println(cipherService.fileEncryptedDecrypted(path, Integer.parseInt(keyFromConsole), operation));
                }
            }
        }
    }

    private String menuOptionFindFile (String text) {
        Scanner scan = new Scanner(System.in);
        String path;
        CipherService cipherService = new CipherService();
        System.out.println(text);
        path = scan.nextLine();
        while (!cipherService.checkPathToFile(path) && !path.equals("exit")) {
            System.out.println(AppConstants.FILE_NOT_FOUND);
            System.out.println(text + AppConstants.WRITE_EXIT_TO_EXIT_MENU_OPTION);
            path = scan.nextLine();
        }
        return path;
    }

    private String menuOptionCheckKey (String text) {
        Scanner scan = new Scanner(System.in);
        String keyFromConsole;

        System.out.println(text);
        keyFromConsole = scan.nextLine();
        while (!keyFromConsole.equals("exit")) {
            try {
                Integer.parseInt(keyFromConsole);
                break;
            } catch (NumberFormatException e) {
                System.out.println(AppConstants.VALUE_NOT_INTEGER);
                System.out.println(text + AppConstants.WRITE_EXIT_TO_EXIT_MENU_OPTION);
            }
            keyFromConsole = scan.nextLine();
        }
        return keyFromConsole;
    }

    public void menuOptionExit() {
        System.out.println(AppConstants.EXIT_TEXT);
    }

    public void menuOptionNotFoundOption() {
        System.out.println(AppConstants.OPTION_NOT_FOUND);
    }
}
