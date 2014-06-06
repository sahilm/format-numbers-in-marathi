package com.sahilm;

import org.junit.Test;

import java.math.BigDecimal;

import static com.sahilm.NumberFormat.spellOutInMarathi;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NumberFormatTest {

    @Test
    public void testSpellOutInMarathi() throws Exception {
        assertThat(spellOutInMarathi(BigDecimal.valueOf(30L)), equalTo("तीस"));
        assertThat(spellOutInMarathi(BigDecimal.valueOf(-78L)), equalTo("ऋण अठ्ठ्याहत्तर"));
        assertThat(spellOutInMarathi(BigDecimal.valueOf(18.9814)), equalTo("अठरा दशमलव नऊ आठ एक चार"));
        assertThat(spellOutInMarathi(BigDecimal.valueOf(-55.75)), equalTo("ऋण पंचावन्न दशमलव सात पाच"));
    }
}