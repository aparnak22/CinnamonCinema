package com.cinnamoncinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    public static final int MAX_ROWS = 3;
    public static final int MAX_COLS = 5;
    public static final  int MAX_CAPACITY_SEATS = MAX_ROWS * MAX_COLS;

    boolean[][] seats = new boolean[MAX_ROWS][MAX_COLS];
    String[] rowNames = {"A","B","C"};

    int seatsBooked = 0;

    public List<String> allocateSeats(int noOfSeatsRequested) {

        List<String> allocatedSeats = new ArrayList<>();

        int noOfSeatsAllocated = 0;
        if ( noOfSeatsRequested <= getAvailableSeats()) {
            int r= 0;
            while ( r < MAX_ROWS && noOfSeatsAllocated < noOfSeatsRequested ){
                int c = 0;
                while ( c < MAX_COLS && noOfSeatsAllocated < noOfSeatsRequested ){
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
