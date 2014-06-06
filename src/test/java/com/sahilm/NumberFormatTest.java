package com.sahilm;

import org.junit.Test;

import java.math.BigDecimal;

import static com.sahilm.NumberFormat.format;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NumberFormatTest {

    @Test
    public void testFormat() throws Exception {
        assertFormatOf(30, "३०, तीस");
        assertFormatOf(145, "१४५, एकशे पंचेचाळीस");
        assertFormatOf(1218, "१२१८, एक हज़ार दोनशे अठरा");
        assertFormatOf(0, "०, शून्य");
        assertFormatOf(100, "१००, शंभर");
        assertFormatOf(-78, "-७८, ऋण अठ्ठ्याहत्तर");
        assertFormatOf(new BigDecimal("18.9139"), "१८.९१४, अठरा दशमलव नऊ एक तीन नऊ");
        assertFormatOf(new BigDecimal("-55.75"), "-५५.७५, ऋण पंचावन्न दशमलव सात पाच");
        assertFormatOf(209, "२०९, दोनशे नऊ");
        assertFormatOf(510, "५१०, पाचशे दहा");
        assertFormatOf(1110, "१११०, एक हज़ार एकशे दहा");
        assertFormatOf(10000, "१००००, दहा हज़ार");
        assertFormatOf(87493, "८७४९३, सत्त्याऐंशी हज़ार चारशे त्र्याण्णव");
        assertFormatOf(123456, "१२३४५६, एक लाख तेवीस हज़ार चारशे छप्पन्न");
        assertFormatOf(100000, "१०००००, एक लाख");
        assertFormatOf(100003, "१००००३, एक लाख तीन");
        assertFormatOf(508007, "५०८००७, पाच लाख आठ हज़ार सात");
        assertFormatOf(99999, "९९९९९, नव्व्याण्णव हज़ार नऊशे नव्व्याण्णव");
        assertFormatOf(1000000000, "१०००००००००, शंभर कोटी");
        assertFormatOf(1000001383, "१०००००१३८३, शंभर कोटी एक हज़ार तीनशे त्र्याऐंशी");
        assertFormatOf(new BigDecimal("1000000000000000000"), "१००००००००००००००००००, 10,00,00,00,00,00,00,00,000");
    }

    private void assertFormatOf(BigDecimal number, String expectedFormat) {
        assertThat(format(number), equalTo(expectedFormat));
    }

    private void assertFormatOf(long number, String expectedFormat) {
        assertFormatOf(BigDecimal.valueOf(number), expectedFormat);
    }
}