package com.cinnamoncinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeatBooker {
    private final Cinema cinema;

    public SeatBooker(Cinema cinema){
        this.cinema = cinema;
    }

    public int bookAllSeats(){
        Random random = new Random();
        List<String> seatsAllocated = null;
        int noOfSeatsRequested ; int totalSeatsBooked = 0;
        while (((seatsAllocated == null) || !seatsAllocated.isEmpty()) && (cinema.getAvailableSeats() > 0)) {
            noOfSeatsRequested = Math.abs(random.nextInt(3))  + 1;

            System.out.print("\nBooking " + noOfSeatsRequested + " seats...");
            seatsAllocated = cinema.allocateSeats(noOfSeatsRequested);

            if ( seatsAllocated!=null ) {
                totalSeatsBooked += seatsAllocated.size();
                seatsAllocated.forEach(s -> System.out.print(s + "  "));
            }
        }
        return totalSeatsBooked;
    }

    public static void main(String[] args){
        Cinema cinema = new Cinema();
        SeatBooker seatBooker = new SeatBooker(cinema);
        int totalSeatsBooked = seatBooker.bookAllSeats();

        System.out.println("Total seats booked " + totalSeatsBooked);

    }
}
