package com.cinnamoncinema;

public class CinemaUtils {

    /**
     *  Generate row names starting from A to Z
     *  and continuing by repeating the letter for rows after Z.
     *  eg: AA,BB,CC....
     *
     * @param noOfRows the number of rows to generate row names for
     */
    public static String[] generateRowNames(int noOfRows) {
        int r = 0; char c = 'A';
        String[] rowNames = new String[noOfRows];
        while (r < noOfRows){
            rowNames[r] = String.valueOf(c).repeat( (r / 26) + 1) ;
            c++;
            r++;
            if ( r % 26 == 0) c = 'A';
        }
        return rowNames;
    }
}
