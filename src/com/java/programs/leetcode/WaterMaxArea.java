package com.java.programs.leetcode;

public class WaterMaxArea {

    public int maxArea(int[] height) {

        int result = 0;
        int head = 0;
        int tail = height.length-1;

        for(int i=0; i<height.length; i++) {

            int width = tail - head;

            if(height[head] < height[tail]) {
                result = Math.max(result, width * height[head]);
                head++;
            }else {
                result = Math.max(result, width * height[tail]);
                tail--;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        WaterMaxArea test = new WaterMaxArea();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(test.maxArea(array));
    }
}
