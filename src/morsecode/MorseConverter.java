package morsecode;

import java.util.HashMap;
import java.util.Map;

public class MorseConverter {
    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    static {
        String[][] morseAlphabet = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."},
                {"E", "."}, {"F", "..-."}, {"G", "--."}, {"H", "...."},
                {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
                {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."},
                {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."}, {"1", ".----"}, {"2", "..---"},
                {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
                {"7", "--..."}, {"8", "---.."}, {"9", "----."}, {"0", "-----"},
                {" ", "/"}
        };

        for (String[] pair : morseAlphabet) {
            textToMorse.put(pair[0].charAt(0), pair[1]);
            morseToText.put(pair[1], pair[0].charAt(0));
        }
    }

    public String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (textToMorse.containsKey(c)) {
                morse.append(textToMorse.get(c)).append(" ");
            } else {
                throw new IllegalArgumentException("Ogiltigt tecken: " + c);
            }
        }
        return morse.toString().trim();
    }

    public String morseToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split(" ");

        for (String morse : words) {
            if (morseToText.containsKey(morse)) {
                text.append(morseToText.get(morse));
            } else {
                throw new IllegalArgumentException("Ogiltig morsekod: " + morse);
            }
        }
        return text.toString();
    }
}