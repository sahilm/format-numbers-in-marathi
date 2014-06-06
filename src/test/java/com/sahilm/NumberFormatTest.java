package com.sahilm;

import org.junit.Test;

import java.math.BigDecimal;

import static com.sahilm.NumberFormat.spellOutInMarathi;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NumberFormatTest {

    @Test
    public void testSpellOutInMarathi() throws Exception {
        assertMarathiSpellingOf(30, "तीस");
        assertMarathiSpellingOf(145, "एकशे पंचेचाळीस");
        assertMarathiSpellingOf(1218, "एक हज़ार दोनशे अठरा");
        assertMarathiSpellingOf(100, "शंभर");
        assertMarathiSpellingOf(-78, "ऋण अठ्ठ्याहत्तर");
        assertMarathiSpellingOf(new BigDecimal("18.9814"), "अठरा दशमलव नऊ आठ एक चार");
        assertMarathiSpellingOf(new BigDecimal("-55.75"), "ऋण पंचावन्न दशमलव सात पाच");
        assertMarathiSpellingOf(209, "दोनशे नऊ");
        assertMarathiSpellingOf(510, "पाचशे दहा");
        assertMarathiSpellingOf(1110, "एक हज़ार एकशे दहा");
        assertMarathiSpellingOf(10000, "दहा हज़ार");
        assertMarathiSpellingOf(87493, "सत्त्याऐंशी हज़ार चारशे त्र्याण्णव");
        assertMarathiSpellingOf(123456, "एक लाख तेवीस हज़ार चारशे छप्पन्न");
        assertMarathiSpellingOf(100000, "एक लाख");
        assertMarathiSpellingOf(100003, "एक लाख तीन");
        assertMarathiSpellingOf(508007, "पाच लाख आठ हज़ार सात");
        assertMarathiSpellingOf(99999, "नव्व्याण्णव हज़ार नऊशे नव्व्याण्णव");
        assertMarathiSpellingOf(1000000000, "शंभर कोटी");
        assertMarathiSpellingOf(1000001383, "शंभर कोटी एक हज़ार तीनशे त्र्याऐंशी");
        assertMarathiSpellingOf(new BigDecimal("1000000000000000000"), "10,00,00,00,00,00,00,00,000");
    }

    private void assertMarathiSpellingOf(BigDecimal number, String expectedSpelling) {
        assertThat(spellOutInMarathi(number), equalTo(expectedSpelling));
    }

    private void assertMarathiSpellingOf(long number, String expectedSpelling) {
        assertMarathiSpellingOf(BigDecimal.valueOf(number), expectedSpelling);
    }
}