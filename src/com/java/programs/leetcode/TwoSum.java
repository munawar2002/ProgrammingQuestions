package com.java.programs;

import java.util.*;

/**
 * Created by Munawar on 4/16/2020.
 */
public class TwoSum {

    public List<int[]> twoSum(int[] nums, int target) {

        List<int[]> allTwoSums = new ArrayList<>();

        Map<Integer,Integer> indexMap = new HashMap<>();

        for(int i=0; i<nums.length;i++){

            int complement = target - nums[i];

            if(indexMap.containsKey(complement)){
                allTwoSums.add(new int[]{indexMap.get(complement),i});
            }

            indexMap.put(nums[i],i);
        }

        return allTwoSums;
    }

    public static void main(String a[]) {
        TwoSum test = new TwoSum();
        int A[] = {0,1,2, 7, 9, 11, 15};
        test.twoSum(A,9).forEach(B -> Arrays.stream(B).forEach(System.out::println));
    }
}
