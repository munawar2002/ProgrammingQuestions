package com.java.programs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> finalIntervals = new ArrayList<>();

        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));

        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        int index=0;
        int start = 0;
        int end = 0;
        boolean added = false;
        for(int[] interval : intervals){
            // intersect point
            if(!added && newInterval[0] < interval[0]) {
                intervalsList.add(index, newInterval);
                added = true;
            }
            index++;
        }

        if(!added){
            intervalsList.add(newInterval);
        }

        added = false;
        for(int i=1; i<intervalsList.size();i++ ){

            int[] currentInterval = intervalsList.get(i);
            int[] prevInterval = intervalsList.get(i-1);

            if(!added && currentInterval[0] <= prevInterval[1]){
                start = i-1;
                added = true;
            }

            if(newInterval[1] >= currentInterval[0] || newInterval[1] >= currentInterval[1]){
                end = i;
            }
        }

        int [] mergedInterval = new int[2];
        index = 0;
        while (index < intervalsList.size()){
            if (added && index >= start && index <= end) {
                if (mergedInterval[1] == 0) {
                    mergedInterval[0] = Math.min(intervalsList.get(start)[0], newInterval[0]);
                    mergedInterval[1] = Math.max(Math.max(intervalsList.get(end)[1], newInterval[1]),intervalsList.get(start)[1]);
                    finalIntervals.add(mergedInterval);
                }
                index++;
                continue;
            } else {
                finalIntervals.add(intervalsList.get(index));
            }
            index++;
        }

        int [][] finalOutput = new int[finalIntervals.size()][2];
        return finalIntervals.toArray(finalOutput);
    }

    public static void main(String[] args) {
        int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval = {4,8};

//        int [][] intervals = {{1,3},{6,9}};
//        int [] newInterval = {2,5};

//        int [][] intervals = {{0,7},{8,8},{9,11}};
//        int [] newInterval = {4,13};

        int [][] output = InsertInterval.insert(intervals,newInterval);
        Arrays.stream(output).forEach(a -> System.out.println(a[0]+","+a[1]));
    }
}

