package com.cinnamoncinema;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestCinemaUtils {

    @Test
    public void testCinemaRowNamesUpto26(){
        String[] rowNames = CinemaUtils.generateRowNames(26);

        assertEquals("A",rowNames[0]);
        assertEquals("Z",rowNames[25]);
    }


    @ParameterizedTest
    @MethodSource("generateCinemaRowTestData")
    public void testCinemaGeneratedRowNames(int noOfRows, List<String> rowNames){
        assertIterableEquals(rowNames, Arrays.asList(CinemaUtils.generateRowNames(noOfRows) ));
    }


    static Stream<Arguments> generateCinemaRowTestData(){
        return Stream.of(
                arguments(10,Arrays.asList("A", "B","C", "D" , "E" , "F" , "G" , "H" , "I" , "J")),
                arguments( 53, Arrays.asList("A", "B","C", "D" , "E" , "F" , "G" , "H" , "I" , "J" ,
                        "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" ,
                        "W" , "X" , "Y" , "Z" , "AA" , "BB" , "CC" , "DD" , "EE" , "FF" ,
                        "GG" , "HH" , "II" , "JJ" , "KK" , "LL" , "MM" , "NN" , "OO" , "PP" , "QQ" , "RR" ,
                        "SS" , "TT" , "UU" , "VV" , "WW" , "XX" , "YY" , "ZZ" , "AAA")));

    }
}

