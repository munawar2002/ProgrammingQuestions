package com.java.programs.others;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sheik on 11/24/2017.
 */


class ShortestSubArray {

    public int findShortestSubArray(int[] arr) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            int def = 0;
            Integer value = count.get(x);
            if(value == null){
                value = def;
            }
            count.put(x, value + 1);
        }
        int ans = arr.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return  ans;
    }


    public static void main(String[] args) {

        ShortestSubArray c = new ShortestSubArray();
        int[] a = {1,2,2,3,1};
        System.out.println(c.findShortestSubArray(a));

    }

}