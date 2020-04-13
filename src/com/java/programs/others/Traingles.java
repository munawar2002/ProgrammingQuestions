package com.java.programs.others;

/**
 * Created by sheik on 11/15/2017.
 */
public class Traingles {

    /**
     1
     2 2
     3 3 3
     4 4 4 4
     5 5 5 5 5
     6 6 6 6 6 6
     7 7 7 7 7 7 7
     8 8 8 8 8 8 8 8
     9 9 9 9 9 9 9 9 9

     **/
    public void triangle1(int noOfRows){
        int rowCount = 1;

        System.out.println("Here Is Your Pyramid");

        //Implementing the logic

        for (int i = noOfRows; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing 'rowCount' data 'rowCount' times at the end of each row

            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print(rowCount+" ");
            }

            System.out.println();

            //Incrementing the rowCount

            rowCount++;
        }
    }

    /**
     1
     1 2
     1 2 3
     1 2 3 4
     1 2 3 4 5
     1 2 3 4 5 6
     1 2 3 4 5 6 7
     1 2 3 4 5 6 7 8
     1 2 3 4 5 6 7 8 9
     * @param noOfRows
     */
    public void triangle2(int noOfRows){
        int rowCount = 1;

        System.out.println("Here Is Your Pyramid");

        //Implementing the logic

        for (int i = noOfRows; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing 'j' data at the end of each row

            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print(j+" ");
            }

            System.out.println();
            //Incrementing the rowCount
            rowCount++;
        }
    }

    public void triangle3(int noOfRows){
        int rowCount = 1;

        System.out.println("Here Is Your Pyramid");

        //Implementing the logic

        for (int i = noOfRows; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }

            //Printing * at the end of each row

            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print("* ");
            }

            System.out.println();

            //Incrementing the rowCount

            rowCount++;
        }
    }

    /**
     1
     2    3
     4    5    6
     7    8    9    10
     11   12   13   14   15
     * @param noOfRows
     */
    public void triangle4(int noOfRows){

        int value = 1;

        System.out.println("Floyd's Triangle : ");

        for (int i = 1; i <= noOfRows; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(value+"\t");

                value++;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Traingles t = new Traingles();
        t.triangle1(9);
        t.triangle2(9);
        t.triangle3(9);
        t.triangle4(5);

    }
}
