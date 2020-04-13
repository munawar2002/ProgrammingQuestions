package com.java.programs.others;

/**
 * Created by sheik on 11/15/2017.
 */
public class DiamondPattern {

    /**
     *
     * *
     * * *
     * * * *
     * * *
     * *
     *
     * @param noOfRows
     */
    public void diamond1(int noOfRows){
        //Getting midRow of the diamond

        int midRow = (noOfRows)/2;

        //Initializing row with 1

        int row = 1;

        System.out.println("Here Is Your Diamond : ");

        //Printing upper half of the diamond

        for (int i = midRow; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing j *'s at the end of each row

            for (int j = 1; j <= row; j++)
            {
                System.out.print("* ");
            }

            System.out.println();

            //Incrementing the row

            row++;
        }

        //Printing lower half of the diamond

        for (int i = 0; i <= midRow; i++)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing j *'s at the end of each row

            for (int j = row; j > 0; j--)
            {
                System.out.print("* ");
            }

            System.out.println();

            //Decrementing the row

            row--;
        }
    }

    /**
     1
     2 2
     3 3 3
     4 4 4 4
     3 3 3
     2 2
     1
     * @param noOfRows
     */
    public void diamond2(int noOfRows){
        //Getting midRow of the diamond

        int midRow = noOfRows/2;

        //Initializing row with 1

        int row = 1;

        System.out.println("Here Is Your Diamond : ");

        //Printing upper half of the diamond

        for (int i = midRow; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing row data j times at the end of each row

            for (int j = 1; j <= row; j++)
            {
                System.out.print(row+" ");
            }

            System.out.println();

            //Incrementing the row

            row++;
        }

        //Printing lower half of the diamond

        for (int i = 0; i <= midRow; i++)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing row data j times at the end of each row

            for (int j = row; j > 0; j--)
            {
                System.out.print(row+" ");
            }

            System.out.println();

            //Decrementing the row

            row--;
        }
    }

    public static void main(String[] args) {
        DiamondPattern p = new DiamondPattern();
    }
}
