package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(3,cinema.allocateSeats(3).size());
        assertEquals(0,cinema.allocateSeats(1).size());
    }
}
