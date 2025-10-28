import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String fromConsole, path;
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        System.out.println("Добро пожаловать в cryptoanalyzer!");

        String realText = "Привет всем!";
        String encryptedText = realText;

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
                    System.out.println("Пожалуйста, введите путь к файлу:");
                    path = scan.nextLine();
                    while (!fileManager.checkPathToFile(path) && !path.equals("exit")) {
                        System.out.println("По указанному пути не удалось найти файл!");
                        System.out.println("Пожалуйста, введите путь к файлу. Если хотите выйти из этого пункта меню, введите exit:");
                        path = scan.nextLine();
                    }
                    if (!path.equals("exit")) {
                        encryptedText = cipher.encrypt(realText, 3);
                        System.out.println(encryptedText);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Расшифровка, уху");
                    System.out.println(cipher.decrypt(encryptedText, 3));
                    break;
                }
                case "3": {
                    System.out.println("Метод brute force, уху");
                    cipher.bruteForce(encryptedText);
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