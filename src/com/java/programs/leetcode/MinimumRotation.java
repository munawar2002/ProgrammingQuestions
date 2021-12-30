package com.java.programs.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumRotation {

    public static void main(String[] args) {
        MinimumRotation s = new MinimumRotation();
        int[] a = {10,-10,-1,-1,10};
        System.out.println(s.solution(a));

        int[] b = {-1,-1,-1,1,1,1,1};
        System.out.println(s.solution(b));

        int[] c = {5,-3,-2,1};
        System.out.println(s.solution(c));
    }

    public int solution(int[] A) {

        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());

        int sum=0;

        int totalRotation=0;
        int i=0;
        int listSize = listA.size();

        while (i < listSize-1) {

            while (sum >= 0 && i<listSize-1) {
                sum += listA.get(i);
                i++;
            }

            int j = listA.size() - 1;
            int rotationCount = 0;
            while (sum < 0) {
                sum += listA.get(j);
                j--;
                rotationCount++;
            }

            if (rotationCount > 0) {
                Collections.rotate(listA, rotationCount);
                totalRotation += rotationCount;
                i=0;
                sum=0;
            }
        }

        return totalRotation;
    }


    public int solution2(int[] A) {

        int count = 0;

        while (true) {
            int sum = 0;
            int maxValueIndex = -1;
            for (int i = 0; i < A.length; i++) {

                sum += A[i];

                if (sum < 0) {
                    count++;
                    if(i==0){
                        maxValueIndex = i;
                    }else if (Math.abs(A[i]) > Math.abs(A[i - 1])) {
                        maxValueIndex = i;
                    } else {
                        maxValueIndex = i - 1;
                    }
                    break;
                }
            }
            if(maxValueIndex > -1){
                rotateArray(A,maxValueIndex);
            }else {
                break;
            }
        }
        // write your code in Java SE 8
        return count;
    }

    private void rotateArray(int[] a, int maxValueIndex) {

        int value = a[maxValueIndex];
        for(int i=maxValueIndex ; i < a.length-1; i++){
            a[i] = a[i+1];
        }

        a[a.length-1] = value;
    }

}
