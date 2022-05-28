package com.cinnamoncinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cinema {

    private static final int DEFAULT_MAX_ROWS = 3;
    private static final int DEFAULT_MAX_COLS = 5;

    private int maxRows;

    private int totalSeatCapacity;

    private List<boolean[]> seats;

    private final  String[] rowNames ;

    int seatsBooked = 0;

    public Cinema(){
        this(DEFAULT_MAX_ROWS,DEFAULT_MAX_COLS);
    }

    public Cinema(int maxRows, int maxCols){
        this(maxRows,maxCols,null);
    }

    /**
     * Create seating plan containing rows with variable no of seats in each or some rows
     * @param maxRows total no of rows in cinema
     * @param defaultNoOfSeats default no of seats in each row
     * @param variableSeatRows map of row number, starting with index 0 and no of seats in that row. Use
     *                         this to specify any rows with number of seats different from the default no of seats
     *                         in each row.
     */

    public Cinema(int maxRows, int defaultNoOfSeats, Map<Integer, Integer> variableSeatRows){
        createSeats(maxRows, defaultNoOfSeats, variableSeatRows);
        rowNames = CinemaUtils.generateRowNames(maxRows);
    }

    private void createSeats(int maxRows, int defaultNoOfSeats,
                             Map<Integer, Integer> variableSeatRows) {
        this.maxRows = maxRows;
        seats = new ArrayList<>();
        int noOfSeatsInRow;
        for (int i = 0; i < maxRows; i++) {
            if (variableSeatRows != null )
                noOfSeatsInRow = variableSeatRows.getOrDefault(i,defaultNoOfSeats);
            else
                noOfSeatsInRow = defaultNoOfSeats;

            boolean[] seatsInRow = new boolean[noOfSeatsInRow];
            Arrays.fill(seatsInRow,false);
            seats.add(seatsInRow);

            totalSeatCapacity += noOfSeatsInRow;
        }
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
            while ( r < maxRows && noOfSeatsAllocated < noOfSeatsRequested ){
                int c = 0;
                boolean[] seatRow = seats.get(r);
                while ( c < seatRow.length && noOfSeatsAllocated < noOfSeatsRequested ){
                    //check that the row has the requested number of seats available
                    if (!seatRow[c] && (seatRow.length-c >= (noOfSeatsRequested - noOfSeatsAllocated))) {
                        seatRow[c] = true;
                        allocatedSeats.add(rowNames[r] + (c+1));
                        noOfSeatsAllocated ++;
                    }
                    c++;
                }
                r++;
            }
        }
        seatsBooked+=noOfSeatsAllocated;
        return allocatedSeats;
    }

    public int getAvailableSeats(){
        return totalSeatCapacity - seatsBooked;
    }
}
