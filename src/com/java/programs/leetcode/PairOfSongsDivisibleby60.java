package com.java.programs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairOfSongsDivisibleby60 {

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] count = new int[60];

        for (int t : time) {
            t %= 60;
            ans += count[(60 - t)];
            ++count[t];
        }

        return ans;
    }

    public static void main(String[] args) {
        PairOfSongsDivisibleby60 s = new PairOfSongsDivisibleby60();
        int[] a = {30,20,150,100,40};
        int[] b = {60,60,60};
        System.out.println(s.numPairsDivisibleBy60(a));

    }

}
