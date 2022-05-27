package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
