package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCinema {

    @Test
    public void testWithAllocatingOneSeat(){
            Cinema cinema = new Cinema();
            assertTrue(cinema.allocateSeats(1));
    }

    @Test
    public void testWithAllocatingFifteenSeats(){
        Cinema cinema = new Cinema();
        assertTrue(cinema.allocateSeats(3));
        assertTrue(cinema.allocateSeats(3));
        assertTrue(cinema.allocateSeats(3));
        assertTrue(cinema.allocateSeats(3));
        assertTrue(cinema.allocateSeats(3));
        assertFalse(cinema.allocateSeats(1));
    }
}
