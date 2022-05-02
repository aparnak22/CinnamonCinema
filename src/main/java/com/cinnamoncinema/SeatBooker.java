package com.cinnamoncinema;

import java.util.Random;

public class SeatBooker {
    private final Cinema cinema;

    public SeatBooker(Cinema cinema){
        this.cinema = cinema;
    }

    public int bookAllSeats(){
        Random random = new Random();
        boolean seatsAllocated = true;
        int noOfSeatsRequested ; int totalSeatsBooked = 0;
        while ( seatsAllocated && cinema.getAvailableSeats() > 0) {
            noOfSeatsRequested = Math.abs(random.nextInt(2))  + 1;
            System.out.println("Booking " + noOfSeatsRequested + " seats...");
            seatsAllocated = cinema.allocateSeats(noOfSeatsRequested);
            if (seatsAllocated ) totalSeatsBooked += noOfSeatsRequested;
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
