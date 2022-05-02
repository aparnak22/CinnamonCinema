package com.cinnamoncinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeatBooker {

    @Test
    public void testBookingAllSeats(){
        Cinema cinema = new Cinema();
        SeatBooker seatBooker = new SeatBooker(cinema);
        int seatsBooked  = seatBooker.bookAllSeats();
        System.out.println("Total seats booked = " + seatsBooked);
        assertTrue(seatsBooked <= 15 && seatsBooked >12);

    }
}
