package com.java.programs.leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length==1){
            return true;
        }

        int iMaxReach = nums[0];

        int i=0;

        while(iMaxReach >= i){
            if(iMaxReach >= nums.length -1){
                return true;
            }

            iMaxReach = Math.max(nums[i]+i, iMaxReach);
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        jumpGame.canJump(nums);

    }
}
