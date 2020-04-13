package com.java.programs.others;

/**
 * Created by sheik on 10/22/2017.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {

    public void findDuplicateChars(String str) {

        Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
        char[] chrs = str.toCharArray();

        for (Character ch : chrs) {
            dupMap.compute(ch, (k, v) -> v == null ? v = 1 : dupMap.get(ch) + 1);
        }

        dupMap.keySet()
                .stream()
                .filter(ch -> dupMap.get(ch) > 1)
                .forEach(ch -> System.out.println(ch + "--->" + dupMap.get(ch)));
    }

    public static void main(String a[]) {
        DuplicateCharsInString dcs = new DuplicateCharsInString();
        dcs.findDuplicateChars("Java2Novice");
    }
}
