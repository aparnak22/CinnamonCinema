package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class TestCinema {

    @Test
    public void testWithAllocatingOneSeat(){
            Cinema cinema = new Cinema();
            List<String> seats = cinema.allocateSeats(1);
            assertEquals(1, seats.size());
            assertEquals("A1", seats.get(0));
    }

    @Test
    public void testWithAllocatingFifteenSeats(){
        Cinema cinema = new Cinema();
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(2,cinema.allocateSeats(2).size());
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(2,cinema.allocateSeats(2).size());
        assertEquals(2,cinema.allocateSeats(2).size());
        assertEquals(0,cinema.allocateSeats(1).size());
    }

    @Test
    public void testAllocatingSeatsTogetherOnARow(){
        //3 rows by 5 cols
        Cinema cinema = new Cinema();
        String[] threeSeatsInRowA = {"A1","A2","A3"};
        String[] threeSeatsInRowB = {"B1","B2","B3"};

        List<String> firstSetOfThreeSeats = cinema.allocateSeats(3);
        List<String> secondSetOfThreeSeats = cinema.allocateSeats(3);

        assertIterableEquals(Arrays.asList(threeSeatsInRowA),firstSetOfThreeSeats);
        assertIterableEquals(Arrays.asList(threeSeatsInRowB),secondSetOfThreeSeats);

    }

    @Test
    public void testCustomisingCinemaSizeWith26Rows5Columns(){
        //26 rows by 10 cols
        Cinema cinema = new Cinema(26,5);

        String[] fourSeatsInRowA = {"A1","A2","A3","A4"};
        String[] threeSeatsInRowB = {"B1","B2","B3"};
        String[] lastSetOfSeatsInRowE = {"E1","E2","E3","E4","E5"};


        List<String> firstSetOfFourSeats = cinema.allocateSeats(4);
        List<String> secondSetOfThreeSeats = cinema.allocateSeats(3);
        cinema.allocateSeats(3); //Row C
        cinema.allocateSeats(4); //Row D
        List<String> lastSetOfSeats = cinema.allocateSeats(5); //Row E

        assertIterableEquals(Arrays.asList(fourSeatsInRowA),firstSetOfFourSeats);
        assertIterableEquals(Arrays.asList(threeSeatsInRowB),secondSetOfThreeSeats);
        assertIterableEquals(Arrays.asList(lastSetOfSeatsInRowE),lastSetOfSeats);

    }

    @Test
    public void testCinemaWithVariableRowSize(){
        //3 rows of 5 and 2 rows of 7
        Map<Integer,Integer> lastTwoRows = new HashMap<>();
        lastTwoRows.put(3,7);
        lastTwoRows.put(4,7);

        Cinema cinema = new Cinema(5,5, lastTwoRows);

        String[] sixSeatsInRowD = {"D1","D2","D3","D4","D5","D6"};
        String[] threeSeatsInRowA = {"A1","A2","A3"};
        String[] lastSetOfSeatsInRowE = {"E1","E2","E3","E4","E5","E6"};


        List<String> firstSetOfSixSeats = cinema.allocateSeats(6);
        List<String> secondSetOfThreeSeats = cinema.allocateSeats(3);
        List<String> lastSetOfSeats = cinema.allocateSeats(6); //Row E

        assertIterableEquals(Arrays.asList(sixSeatsInRowD),firstSetOfSixSeats);
        assertIterableEquals(Arrays.asList(threeSeatsInRowA),secondSetOfThreeSeats);
        assertIterableEquals(Arrays.asList(lastSetOfSeatsInRowE),lastSetOfSeats);

    }
}
