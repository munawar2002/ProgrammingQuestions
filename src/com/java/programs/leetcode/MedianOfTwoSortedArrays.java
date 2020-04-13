package com.java.programs.leetcode;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedLength = nums1.length+ nums2.length;
        int[] merged = new int[mergedLength];

        int i=0,j=0;
        int count = 0;
        while(i<nums1.length || j<nums2.length){
            int jValue = Integer.MAX_VALUE;
            if(j < nums2.length){
                jValue = nums2[j];
            }

            int iValue = Integer.MAX_VALUE;
            if(i < nums1.length){
                iValue = nums1[i];
            }

            if(iValue <= jValue){
                merged[count++]= iValue;
                i++;
            }else{
                merged[count++]= jValue;
                j++;
            }
        }

        double median =0;
        if(mergedLength % 2 == 1) {
            median = merged[mergedLength/2];
        }else {
            median = ((double)merged[mergedLength/2] + (double) merged[(mergedLength/2)-1])/2;
        }

        return median;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();

        int[] a = {1, 2};
        int[] b = {3,4};

        double count = test.findMedianSortedArrays(a,b);
        System.out.println(count);
    }
}
