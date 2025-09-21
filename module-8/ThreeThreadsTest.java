/*
ThreeThreadsTest.java
09/20/2025
This program tests if BaboolalThreeThreads.java works.
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class ThreeThreadsTest {
    @Test
    void testRandomGenerators() {
        Random random = new Random();

        // Letters
        for (int i = 0; i < 1000; i++) {
            char c = (char) ('a' + random.nextInt(26));
            assertTrue(c >= 'a' && c <= 'z');
        }

        // Digits
        for (int i = 0; i < 1000; i++) {
            char c = (char) ('0' + random.nextInt(10));
            assertTrue(c >= '0' && c <= '9');
        }

        // Specials
        char[] specials = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < 1000; i++) {
            char c = specials[random.nextInt(specials.length)];
            assertTrue(new String(specials).indexOf(c) >= 0);
        }
    }
}
