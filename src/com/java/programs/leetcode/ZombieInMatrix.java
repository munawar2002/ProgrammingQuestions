package com.java.programs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Question:
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
 * Find out how many hours does it take to infect all humans?

 Example:

 Input:
 [[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

 Output: 2

 Explanation:
 At the end of the 1st hour, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

 At the end of the 2nd hour, the status of the grid:
 [[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
 *
 * Created by Munawar on 4/18/2020.
 */
public class ZombieInMatrix {
    public int maxHoursToBecomeZombie(int[][] array) {

        Queue<String> queue = new ArrayDeque();

        int totalOneCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    queue.add(i + "" + j);
                    totalOneCount++;
                }
            }
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (totalOneCount == array.length * array[0].length) {
                break;
            }

            for (int i = 0; i < size; i++) {
                String infected = queue.poll();
                int iIndex = Character.getNumericValue(infected.charAt(0));
                int jIndex = Character.getNumericValue(infected.charAt(1));

                totalOneCount = infectUp(queue, array, iIndex, jIndex, totalOneCount);

                totalOneCount = infectDown(queue, array, iIndex, jIndex, totalOneCount);

                totalOneCount = infectLeft(queue, array, iIndex, jIndex, totalOneCount);

                totalOneCount = infectRight(queue, array, iIndex, jIndex, totalOneCount);
            }
            count++;
            printArray(array,count);
        }

        return count;
    }

    private void printArray(int[][] array,int count) {
        System.out.println("After hour "+count);
        Arrays.stream(array).forEach(a -> {
            Arrays.stream(a).forEach(value -> {
                System.out.print(value + " ");
            });
            System.out.println();
        });
        System.out.println("----------------------------------");
    }


    private int infectUp(Queue<String> queue, int[][] array, int i, int j, int totalOneCount) {
        if (i > 0 && array[i - 1][j] != 1) {
            array[i - 1][j] = 1;
            queue.add((i - 1) + "" + j);
            totalOneCount++;
        }
        return totalOneCount;
    }

    private int infectDown(Queue<String> queue, int[][] array, int i, int j, int totalOneCount) {
        if (i < array.length - 1 && array[i + 1][j] != 1) {
            array[i + 1][j] = 1;
            queue.add((i + 1) + "" + j);
            totalOneCount++;
        }
        return totalOneCount;
    }

    private int infectLeft(Queue<String> queue, int[][] array, int i, int j, int totalOneCount) {
        if (j > 0 && array[i][j - 1] != 1) {
            array[i][j - 1] = 1;
            queue.add(i + "" + (j - 1));
            totalOneCount++;
        }
        return totalOneCount;
    }

    private int infectRight(Queue<String> queue, int[][] array, int i, int j, int totalOneCount) {
        if (j < array[0].length - 1 && array[i][j + 1] != 1) {
            array[i][j + 1] = 1;
            queue.add(i + "" + (j + 1));
            totalOneCount++;
        }
        return totalOneCount;
    }

    public static void main(String[] args) {
        ZombieInMatrix test = new ZombieInMatrix();

        int[][] A = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};

        System.out.println(test.maxHoursToBecomeZombie(A));


    }
}
