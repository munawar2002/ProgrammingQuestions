package com.java.programs.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }else if(strs.length==1){
            return strs[0];
        }

        String commonPrefix = getCommonPrefix(strs[0],strs[1]);

        for(int i=2;i<strs.length && !commonPrefix.isEmpty();i++){
            commonPrefix = getCommonPrefix(commonPrefix,strs[i]);
        }

        return commonPrefix;
    }

    private String getCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(),str2.length());
        int count = 0;
        for(int i = 0; i <len; i++) {

            if(str1.charAt(i) != str2.charAt(i)){
                break;
            }

            count++;
        }
        return str1.substring(0,count);
    }


    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] str = {"flower","flow","Shah","Dam","Dam","Dam","Dam","Dam"};
        System.out.println(test.longestCommonPrefix(str));
    }

}
