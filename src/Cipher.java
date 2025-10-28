import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {

    private static final ArrayList<Character> ALPHABET = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '));

    public String encrypt(String text, int shift) {
        String result = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char oneCharacter = text.charAt(i);
            int numberOfCharacter = ALPHABET.indexOf(oneCharacter);
            if (numberOfCharacter == -1) {
                result += oneCharacter;
            } else {
                int numberOfShift = (numberOfCharacter + shift) % ALPHABET.size();
                result += ALPHABET.get(numberOfShift);
            }

        }
        return result;
    }

    public String decrypt(String text, int shift) {
        String result = "";
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char oneCharacter = text.charAt(i);
            int numberOfCharacter = ALPHABET.indexOf(oneCharacter);
            if (numberOfCharacter == -1) {
                result += oneCharacter;
            } else {
                int numberOfShift = (ALPHABET.size() + numberOfCharacter - shift) % ALPHABET.size();
                result += ALPHABET.get(numberOfShift);
            }

        }
        return result;
    }

    public void bruteForce(String text) {
        for (int i = 0; i < ALPHABET.size(); i++) {
            System.out.println(decrypt(text, i));
        }
    }

}
