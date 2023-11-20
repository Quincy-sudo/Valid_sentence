import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    void testIsValidSentence() {
        assertTrue(Main.isValidSentence("The quick brown fox said “hello Mr lazy dog”."));
        assertTrue(Main.isValidSentence("The quick brown fox said hello Mr lazy dog."));
        assertTrue(Main.isValidSentence("One lazy dog is too few, 13 is too many."));
        assertTrue(Main.isValidSentence("One lazy dog is too few, thirteen is too many."));
        assertTrue(Main.isValidSentence("How many \"lazy dogs\" are there?"));

        assertFalse(Main.isValidSentence("The quick brown fox said \"hello Mr. lazy dog\"."));
        assertFalse(Main.isValidSentence("the quick brown fox said “hello Mr lazy dog\"."));
        assertFalse(Main.isValidSentence("\"The quick brown fox said “hello Mr lazy dog.\""));
        assertFalse(Main.isValidSentence("One lazy dog is too few, 12 is too many."));
        assertFalse(Main.isValidSentence("Are there 11, 12, or 13 lazy dogs?"));
        assertFalse(Main.isValidSentence("There is no punctuation in this sentence"));
    }
}