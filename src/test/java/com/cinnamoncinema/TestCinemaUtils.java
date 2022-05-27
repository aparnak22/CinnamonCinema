package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCinemaUtils {

    @Test
    public void testCinemaRowNamesUpto26(){
        String[] rowNames = CinemaUtils.generateRowNames(26);

        assertEquals("A",rowNames[0]);
        assertEquals("Z",rowNames[25]);
    }


    @Test
    public void testCinemaRowNamesUpto52(){
        String[] rowNames = CinemaUtils.generateRowNames(52);

        assertEquals("A",rowNames[0]);
        assertEquals("J",rowNames[9]);
        assertEquals("Z",rowNames[25]);
        assertEquals("AA",rowNames[26]);
        assertEquals("KK",rowNames[36]);
        assertEquals("ZZ",rowNames[51]);
    }
}

