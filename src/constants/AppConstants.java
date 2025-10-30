package constants;

public interface AppConstants {
    String GREETING = "Добро пожаловать в cryptoanalyzer!";
    String WHAT_DO_YOU_WANT = "Что вы хотите сделать?";
    String OPTION_MENU_ENCRYPT = "1. Зашифровать текст";
    String OPTION_MENU_DECRYPT = "2. Расшифровать текст";
    String OPTION_MENU_BRUTE_FORCE = "3. Произвести расшифровку текста с помощью brute force (перебор всех вариантов)";
    String OPTION_MENU_EXIT = "0. Завершить работу программы";
    String WRITE_YOUR_ACTION = "Введите в консоль цифру действия, которое хотите совершить";
    String WRITE_PATH_TO_FILE_TO_DECRYPT = "Пожалуйста, введите путь к файлу, который вы хотите дешифровать:";
    String WRITE_PATH_TO_FILE_TO_ENCRYPT = "Пожалуйста, введите путь к файлу, который вы хотите зашифровать:";
    String WRITE_PATH_TO_FILE_FOR_BRUTE_FORCE = "Пожалуйста, введите путь к файлу, который вы хотите \"взломать\":";
    String WRITE_KEY_FOR_ENCRYPT = "Пожалуйста, введите сдвиг по алфавиту (ключ для шифра Цезаря).";
    String WRITE_KEY_FOR_DECRYPT = "Пожалуйста, введите сдвиг по алфавиту (ключ для дешифровки).";
    String WRITE_EXIT_TO_EXIT_MENU_OPTION = " Если хотите выйти из этого пункта меню, введите exit:";
    String FILE_NOT_FOUND = "По указанному пути не удалось найти файл!";
    String VALUE_NOT_INTEGER = "Введенное вами значение не является числом!";
    String ENCRYPT_TEXT = "ШИФРОВАНИЕ ТЕКСТА";
    String DECRYPT_TEXT = "ДЕШИФРОВАНИЕ ТЕКСТА";
    String BRUTE_FORCE_TEXT = "ДЕШИФРОВАНИЕ ТЕКСТА МЕТОДОМ BRUTE FORCE";
    String EXIT_TEXT = "Выход из программы";
    String OPTION_NOT_FOUND = "Вы ввели значение не из меню. Пожалуйста, введите значение заново. Напоминаем пункты меню";
    String FILE_NAME_AFTER_ENCRYPTION = "_encrypted";
    String FILE_NAME_AFTER_DECRYPTION = "_decrypted";
    String SUCCESSFUL_OPERATION_ENCRYPTION = "Операция шифрования прошла успешно! Файл находится в той же директории";
    String SUCCESSFUL_OPERATION_DECRYPTION = "Операция дешифрования прошла успешно! Файл находится в той же директории";
    String SUCCESSFUL_OPERATION_BRUTE_FORCE = "Операция дешифрования методом brute force прошла успешно! Файлы находятся в той же директории";
}
