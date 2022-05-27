package com.cinnamoncinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private static final int DEFAULT_MAX_ROWS = 3;
    private static final int DEFAULT_MAX_COLS = 5;

    private static int MAX_ROWS ;
    private static int MAX_COLS ;

    private static int MAX_CAPACITY_SEATS;

    private final boolean[][] seats;

    private final String[] rowNames ;

    int seatsBooked = 0;

    public Cinema(){
        this(DEFAULT_MAX_ROWS,DEFAULT_MAX_COLS);
    }

    public Cinema(int maxRows, int maxCols){
        MAX_ROWS = maxRows;
        MAX_COLS = maxCols;
        MAX_CAPACITY_SEATS = MAX_ROWS * MAX_COLS;
        seats = new boolean[MAX_ROWS][MAX_COLS];
        rowNames = CinemaUtils.generateRowNames(maxRows);
    }


    /**
     * Allocate the given number of seats.
     * Seats are allocated together on a single row from right to left.
     * No seats are allocated when all seats are booked or seats cannot be
     * booked together on a single row.
     *
     * @param noOfSeatsRequested No of seats/tickets to be allocated
     * @return List of seat numbers as a string in the format "<row name><seat number>"
     * An empty list is returned when no seats are allocated.
     */
    public List<String> allocateSeats(int noOfSeatsRequested) {

        List<String> allocatedSeats = new ArrayList<>();

        int noOfSeatsAllocated = 0;
        if ( noOfSeatsRequested <= getAvailableSeats()) {
            int r= 0;
            while ( r < MAX_ROWS && noOfSeatsAllocated < noOfSeatsRequested ){
                int c = 0;
                while ( c < MAX_COLS && noOfSeatsAllocated < noOfSeatsRequested ){
                    //check that the row has the requested number of seats available
                    if (!seats[r][c] && (MAX_COLS-c >= (noOfSeatsRequested - noOfSeatsAllocated))) {
                        seats[r][c] = true;
                        allocatedSeats.add(rowNames[r] + (c+1));
                        noOfSeatsAllocated ++;
                    }
                    c++;

                }
                r++;
            }
        }
        return allocatedSeats;
    }

    public int getAvailableSeats(){
        return MAX_CAPACITY_SEATS  - seatsBooked;
    }
}
