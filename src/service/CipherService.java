package service;

import constants.AppConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CipherService {

    private static final ArrayList<Character> ALPHABET = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));

    public String encryptDecrypt(String text, int shift, char operation) {
        String result = "";
        text = text.toLowerCase();
        if (shift < 0) {
            shift = (-1 * shift / ALPHABET.size() + 1)* ALPHABET.size() + shift;
        }
        for (int i = 0; i < text.length(); i++) {
            char oneCharacter = text.charAt(i);
            int numberOfCharacter = ALPHABET.indexOf(oneCharacter);
            if (numberOfCharacter == -1) {
                result += oneCharacter;
            } else {
                int numberOfShift;
                if (operation == '+') {
                    numberOfShift = (numberOfCharacter + shift) % ALPHABET.size();
                } else {
                    numberOfShift = (ALPHABET.size() + numberOfCharacter - shift) % ALPHABET.size();
                }
                result += ALPHABET.get(numberOfShift);
            }

        }
        return result;
    }

    public boolean checkPathToFile(String path) {
        File f = new File(path);
        return f.isFile();
    }

    public String fileEncryptedDecrypted(String path, int keyCipher, char operation) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        BufferedWriter bufferedWriter;
        String returnText;

        if (operation == '+') {
            bufferedWriter = writeText(path, AppConstants.FILE_NAME_AFTER_ENCRYPTION);
            returnText = AppConstants.SUCCESSFUL_OPERATION_ENCRYPTION;
        } else {
            bufferedWriter = writeText(path, AppConstants.FILE_NAME_AFTER_DECRYPTION);
            returnText = AppConstants.SUCCESSFUL_OPERATION_DECRYPTION;
        }

        String textLine;
        CipherService cipherService = new CipherService();
        while ((textLine = bufferedReader.readLine()) != null) {
            if (operation == '+') {
                bufferedWriter.write(cipherService.encryptDecrypt(textLine, keyCipher, '+'));
            } else {
                bufferedWriter.write(cipherService.encryptDecrypt(textLine, keyCipher, '-'));
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
        return returnText;
    }


    public String fileBruteForce(String path) throws IOException {
        CipherService cipherService = new CipherService();
        for (int i = 1; i < ALPHABET.size(); i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            BufferedWriter bufferedWriter = writeText(path, AppConstants.FILE_NAME_AFTER_DECRYPTION + i);
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cipherService.encryptDecrypt(textLine, i, '-'));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            bufferedReader.close();
        }
        return AppConstants.SUCCESSFUL_OPERATION_BRUTE_FORCE;
    }

    public BufferedWriter writeText (String path, String name) throws IOException {
        int indexOfLastSlash = path.lastIndexOf('\\');
        int indexOfExtension = path.lastIndexOf('.');
        String pathDirectory = path.substring(0, indexOfLastSlash + 1);
        String nameFile = path.substring(indexOfLastSlash + 1, indexOfExtension);
        pathDirectory += nameFile + name + path.substring(indexOfExtension);
        return new BufferedWriter(new FileWriter(pathDirectory));
    }

}
