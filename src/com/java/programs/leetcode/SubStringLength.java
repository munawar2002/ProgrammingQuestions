package com.java.programs.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringLength {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int ans=0,i=0;

        for(int j=0; j<s.length();j++){

            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }

            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;

    }

    public int lengthOfLongestSubstringSliddingWindow(String s) {
        int n = s.length();

        int ans=0,i=0,j=0;

        Set<Character> set = new HashSet<>();

        while(i < n && j < n) {

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }

        }
        return ans;
    }

    public int lengthOfLongestSubstringBruteForce(String s) {

        if(s.isEmpty()){
            return 0;
        }

        int count = 1;
        int max=1;
        for (int fromIndex = 0; fromIndex < s.length(); fromIndex++) {
            boolean misMatch = false;
            for (int toIndex = s.length(); toIndex>fromIndex+1 ; toIndex--) {
                String subString = s.substring(fromIndex, toIndex);
//                System.out.println(subString);
                count = 1;
                Map<Character, Boolean> occurrence = new HashMap<>();
                misMatch = false;
                for (int k = 1; k < subString.length(); k++) {

                    char first = subString.charAt(k - 1);
                    char second = subString.charAt(k);

                    if (first != second && !occurrence.containsKey(first) && !occurrence.containsKey(second)) {
                        occurrence.put(first, true);
                        count++;
                    } else {
                        occurrence.clear();
                        misMatch = true;
                        break;
                    }
                }
                if (!misMatch && count > 1) {
                    // System.out.println(subString);
                    break;
                }
            }
            if (!misMatch && count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        SubStringLength test = new SubStringLength();
        int count = test.lengthOfLongestSubstringOptimized("abcabcbb");
        System.out.println(count);
        //test.lengthOfLongestSubstring("abc");

    }
}
