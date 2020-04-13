package com.java.programs.others;

/**
 * Created by sheik on 11/15/2017.
 */
public class SelectionSort {
   static void selectionSort(int[] inputArray)
        {
            int temp, pos;

            for (int i = 0; i < inputArray.length - 1; i++)
            {
                pos = i;

                //finding the position of smallest element between (i+1)th element and last element

                for (int j = i+1; j < inputArray.length; j++)
                {
                    if(inputArray[j] < inputArray[pos] )
                    {
                        pos = j;
                    }
                }

                //Swapping inputArray[i] and inputArray[pos]

                temp = inputArray[i];

                inputArray[i] = inputArray[pos];

                inputArray[pos] = temp;
            }

            for (int i = 0; i < inputArray.length; i++)
            {
                System.out.print(inputArray[i] + " ");
            }

            System.out.println();
        }

        public static void main(String[] args)
        {
            selectionSort(new int[] {45, 84, 101, 62, 12, 45});

            selectionSort(new int[] {62, -45, 14, 8, -52, 45});

            selectionSort(new int[] {21, 12, 56, -48, 15, 45});
        }
    }
