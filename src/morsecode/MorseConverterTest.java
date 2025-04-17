package morsecode;

import org.junit.Test;
import static org.junit.Assert.*;

public class MorseConverterTest {

    private final MorseConverter converter = new MorseConverter();

    @Test
    public void testTextToMorse() {
        assertEquals(".... . .---", converter.textToMorse("HEJ"));
        assertEquals(".- -... -.-.", converter.textToMorse("ABC"));
    }

    @Test
    public void testMorseToText() {
        assertEquals("HEJ", converter.morseToText(".... . .---"));
        assertEquals("ABC", converter.morseToText(".- -... -.-."));
    }

    @Test
    public void testInvalidCharacter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            converter.textToMorse("!!!");
        });
        assertTrue(exception.getMessage().contains("Ogiltigt tecken"));
    }
}