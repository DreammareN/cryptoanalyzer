import service.CipherService;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String fromConsole, path, keyFromConsole;
        int keyCipher = 0;
        CipherService cipherService = new CipherService();
        System.out.println("Добро пожаловать в cryptoanalyzer!");

        while(true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Зашифровать текст");
            System.out.println("2. Расшифровать текст");
            System.out.println("3. Произвести расшифровку текста с помощью brute force (перебор всех вариантов)");
            System.out.println("0. Завершить работу программы");
            System.out.println("Введите в консоль цифру действия, которое хотите совершить");

            fromConsole = scan.nextLine();
            switch (fromConsole) {
                case "1": {
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
                    break;
                }
                case "2": {
                    System.out.println("Пожалуйста, введите путь к файлу, который вы хотите дешифровать:");
                    path = scan.nextLine();
                    while (!cipherService.checkPathToFile(path) && !path.equals("exit")) {
                        System.out.println("По указанному пути не удалось найти файл!");
                        System.out.println("Пожалуйста, введите путь к файлу. Если хотите выйти из этого пункта меню, введите exit:");
                        path = scan.nextLine();
                    }
                    if (!path.equals("exit")) {
                        System.out.println("Пожалуйста, введите сдвиг по алфавиту (ключ для дешифровки)");
                        keyFromConsole = scan.nextLine();
                        while (!keyFromConsole.equals("exit")) {
                            try {
                                keyCipher = Integer.parseInt(keyFromConsole);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Введенное вами значение не является числом!");
                                System.out.println("Пожалуйста, введите сдвиг по алфавиту (ключ для дешифровки). Если хотите выйти из этого пункта меню, введите exit:");
                            }
                            keyFromConsole = scan.nextLine();
                        }
                        if (!keyFromConsole.equals("exit")) {
                            cipherService.fileEncryptedDecrypted(path, keyCipher, '-');
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("Пожалуйста, введите путь к файлу, который вы хотите \"взломать\":");
                    path = scan.nextLine();
                    while (!cipherService.checkPathToFile(path) && !path.equals("exit")) {
                        System.out.println("По указанному пути не удалось найти файл!");
                        System.out.println("Пожалуйста, введите путь к файлу. Если хотите выйти из этого пункта меню, введите exit:");
                        path = scan.nextLine();
                    }
                    if (!path.equals("exit")) {
                        cipherService.fileBruteForce(path);
                    }
                    break;
                }
                case "0": {
                    System.out.println("Выход из программы");
                    return;
                }
                default: {
                    System.out.println("Вы ввели значение не из меню. Пожалуйста, введите значение заново. Напоминаем пункты меню");
                    break;
                }
            }

        }

    }
}