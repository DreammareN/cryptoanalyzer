package menu;

import service.CipherService;

import java.io.IOException;
import java.util.Scanner;

public class AppMenu {

    public void menuOptionText (char operation) throws IOException {
        Scanner scan = new Scanner(System.in);
        String path, keyFromConsole;
        int keyCipher = 0;
        CipherService cipherService = new CipherService();
        System.out.println("Пожалуйста, введите путь к файлу, который вы хотите зашифровать:");
        path = scan.nextLine();
        while (!cipherService.checkPathToFile(path) && !path.equals("exit")) {
            System.out.println("По указанному пути не удалось найти файл!");
            System.out.println("Пожалуйста, введите путь к файлу. Если хотите выйти из этого пункта меню, введите exit:");
            path = scan.nextLine();
        }
        if (!path.equals("exit")) {
            System.out.println("Пожалуйста, введите сдвиг по алфавиту (ключ для шифра Цезаря)");
            keyFromConsole = scan.nextLine();
            while (!keyFromConsole.equals("exit")) {
                try {
                    keyCipher = Integer.parseInt(keyFromConsole);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введеное вами значение не является числом!");
                    System.out.println("Пожалуйства, введите сдвиг по алфавиту (ключ для шифра Цезаря). Если хотите выйти из этого пункта меню, введите exit:");
                }
                keyFromConsole = scan.nextLine();
            }
            if (!keyFromConsole.equals("exit")) {
                cipherService.fileEncryptedDecrypted(path, keyCipher, '+');
            }
        }
    }

    public String menuOptionFindFile () {
        Scanner scan = new Scanner(System.in);
        String path;
        CipherService cipherService = new CipherService();
        System.out.println("Пожалуйста, введите путь к файлу, который вы хотите \"взломать\":");
        path = scan.nextLine();
        while (!cipherService.checkPathToFile(path) && !path.equals("exit")) {
            System.out.println("По указанному пути не удалось найти файл!");
            System.out.println("Пожалуйста, введите путь к файлу. Если хотите выйти из этого пункта меню, введите exit:");
            path = scan.nextLine();
        }
        return path;
    }
}
