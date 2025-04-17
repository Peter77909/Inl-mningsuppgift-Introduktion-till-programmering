import java.util.HashMap;import java.util.Map;
import java.util.Scanner;

// Logik-klass för Morse-kod konvertering
class MorseConverter {
    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    static {
        String[][] morseArray = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."}, {" ", "/"} // Mellanslag hantering
        };

        for (String[] entry : morseArray) {
            textToMorse.put(entry[0].charAt(0), entry[1]);
            morseToText.put(entry[1], entry[0].charAt(0));
        }
    }

    public static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            String morse = textToMorse.get(c);
            if (morse != null) {
                morseCode.append(morse).append(" ");
            } else {
                throw new IllegalArgumentException("Ogiltig bokstav: " + c);
            }
        }
        return morseCode.toString().trim();
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        for (String letter : morse.split(" ")) {
            Character character = morseToText.get(letter);
            if (character != null) {
                text.append(character);
            } else {
                throw new IllegalArgumentException("Ogiltig morsekod: " + letter);
            }
        }
        return text.toString().replace("/", " "); // Återställ mellanslag
    }
}

// Main-klass för att läsa in och skriva ut text
public class MorseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj alternativ: \n1. Text till Morse \n2. Morse till Text");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println(choice == 1 ? "Skriv in text att konvertera till morsekod:" : "Skriv in morsekod att konvertera till text (separera bokstäver med mellanslag):");
        String input = scanner.nextLine();

        try {
            String output = (choice == 1) ? MorseConverter.textToMorse(input) : MorseConverter.morseToText(input);
            System.out.println(choice == 1 ? "Morsekod: " + output : "Text: " + output);
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage());
        }

        scanner.close();
    }
}