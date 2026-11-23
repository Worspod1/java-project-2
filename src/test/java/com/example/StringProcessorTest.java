package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    private StringProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new StringProcessor();
    }

    // Тесты для repeat
    @Test
    void repeat_positiveN_returnsConcatenation() {
        assertEquals("abcabcabc", processor.repeat("abc", 3));
    }
    @Test
    void repeat_nEqualsZero_returnsEmptyString() {
        assertEquals("", processor.repeat("abc", 0));
    }
    @Test
    void repeat_negativeN_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> processor.repeat("abc", -1));
    }

    // Тесты для countOccurrences
    @Test
    void countOccurrences_basicCase() {
        assertEquals(3, processor.countOccurrences("abcabcabc", "abc"));
    }
    @Test
    void countOccurrences_emptySubstr_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> processor.countOccurrences("abc", ""));
    }

    // Тесты для replaceDigits
    @Test
    void replaceDigits_basicCase() {
        assertEquals("одиндватри", processor.replaceDigits("123"));
    }
    @Test
    void replaceDigits_mixedContent() {
        assertEquals("aодинbдваcтри", processor.replaceDigits("a1b2c3"));
    }
}