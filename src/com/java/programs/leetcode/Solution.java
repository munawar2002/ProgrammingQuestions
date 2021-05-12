package com.java.programs.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    /**
     * * Munawar comments: I think the test cases are failing incorrectly.
     * Consider this input : 1,0,1,0,0,0,0,1
     * We can sort it in 2 moves But hackerrank is saying 6 atleast moves are needed.
     */

    public static int getMinimumUniqueSum(List<Integer> arr) {
        Map<Integer, Integer> digitFrequency = new ConcurrentHashMap<>();

        arr.forEach(value -> digitFrequency.compute(value, (k,v) -> v!= null ? v+1 :1));

        digitFrequency.forEach((k,v) -> {
            if(v >1){
                Integer num = getMissingNumber(digitFrequency,v);
                digitFrequency.put(num, 1);
                digitFrequency.put(k,v-1);
            }

        });

        final int[] sum = {0};
        digitFrequency.keySet().forEach(num -> {
            sum[0] = sum[0] +num;
        });

        return sum[0];
    }

    private static Integer getMissingNumber(Map<Integer, Integer> digitFrequency, int num) {
        for(int i=num+1; i<2000 ; i++){
            if(!digitFrequency.containsKey(i)){
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Solution test = new Solution();
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,2,4,5));
        System.out.println(Solution.getMinimumUniqueSum(arr));
    }

//    public static String isPossible(int a, int b, int c, int d) {
//        // Write your code here
//        while (a < c || b < d) {
//            if((c-a < d-b && a !=c) || d==b ){
//                if (a + b <= c) {
//                    a = a + b;
//                }
//            }else if((d-b < c-a && b!=d) || c ==a){
//                if (a + b <= d) {
//                    b = a + b;
//                }
//            }
//        }
//
//        if (a == c && b == d) {
//            return "Yes";
//        } else {
//            return "No";
//        }
//    }



 //   public static int minMoves(List<Integer> arr) {
//        // Write your code here
//        int left=0;
//        int right= arr.size()-1;
//
//        List<Integer> arrRight = new ArrayList(Arrays.asList(arr.toArray()));
//
////        int count = Math.min(getCountByPuttingZeroAtRight(arrRight, left, right),
////                getCountByPuttingZeroAtLeft(arr, left, right));
//        int count = getCountByPuttingZeroAtLeft(arr, left, right);
//
//        return count;
//    }
//
//    private static int getCountByPuttingZeroAtRight(List<Integer> arr, int left, int right) {
//        int count =0;
//        while(left<right){
//
//            if(arr.get(left) ==0){
//                if(arr.get(right) == 1){
//                    swap(arr,left,right);
//                    count++;
//                }else {
//                    right--;
//                }
//            }else {
//                left++;
//            }
//        }
//        return count;
//    }
//
//    private static int getCountByPuttingZeroAtLeft(List<Integer> arr, int left, int right) {
//        int count =0;
//        while(left<right){
//
//            if(arr.get(right) ==0){
//                if(arr.get(left) == 1){
//                    swap(arr,left,right);
//                    count++;
//                }else {
//                    left++;
//                }
//            }else {
//                right--;
//            }
//        }
//        return count;
//    }
//
//    private static void swap(List<Integer> arr, int left, int right) {
//        int temp = arr.get(left);
//        arr.set(left,arr.get(right));
//        arr.set(right,temp);
//    }


        //  public int solution(String S) {
//        // write your code in Java 8
//
//        Map<Character, List<Character>> eatingMap = getEatingMap();
//
//        int alive = S.length();
//
//        int counterCheck = 0;
//        while (!S.isEmpty() && S.length()>1 && counterCheck < S.length()) {
//            for (int i = 0; i < S.length() - 1; i++) {
//
//                char eater = S.charAt(i);
//                char eats = S.charAt(i + 1);
//
//                if (eatingMap.get(eater).contains(eats)) {
//                    alive--;
//                    S = S.substring(0, i + 1) + S.substring(i + 2, S.length());
//                }
//            }
//            counterCheck++;
//        }
//
//        return  alive;
//
//    }
//
//    private Map<Character, List<Character>> getEatingMap() {
//        Map<Character,List<Character>> eatingMap = new HashMap<>();
//
//        List<Character> fishA = new ArrayList<>();
//        fishA.add('B');
//        fishA.add('C');
//        eatingMap.put('A',fishA);
//
//        List<Character> fishB = new ArrayList<>();
//        fishB.add('C');
//        fishB.add('D');
//        eatingMap.put('B',fishB);
//
//        List<Character> fishC = new ArrayList<>();
//        fishC.add('D');
//        eatingMap.put('C',fishC);
//
//        List<Character> fishD = new ArrayList<>();
//        eatingMap.put('D',new ArrayList<>());
//        return eatingMap;
//    }



}
