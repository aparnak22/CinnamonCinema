package com.cinnamoncinema;

public class Cinema {

    public static final int MAX_ROWS = 3;
    public static final int MAX_COLS = 5;
    public static final int MAX_CAPACITY_SEATS = MAX_ROWS * MAX_COLS;

    boolean[][] seats = new boolean[MAX_ROWS][MAX_COLS];
    int seatsBooked = 0;

    public boolean allocateSeats(int noOfSeatsRequested) {
        int noOfSeatsAllocated = 0;
        if ( noOfSeatsRequested <= getAvailableSeats()) {
            int r= 0;
            while ( r < MAX_ROWS && noOfSeatsAllocated < noOfSeatsRequested ){
                int c = 0;
                while ( c< MAX_COLS && noOfSeatsAllocated < noOfSeatsRequested ){
                    if (!seats[r][c]) {
                        seats[r][c] = true;
                        noOfSeatsAllocated ++;
                    }
                    c++;
                }
                r++;
            }
        }
        return noOfSeatsAllocated == noOfSeatsRequested;
    }

    public int getAvailableSeats(){
        return MAX_CAPACITY_SEATS  - seatsBooked;
    }
}
