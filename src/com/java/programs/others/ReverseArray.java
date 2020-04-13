package com.java.programs.others;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sheik on 5/1/2018.
 */
public class ReverseArray {

    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */

        if(a == null)
            return null;

        else{
            Collections.reverse(Arrays.asList(a)); //reverse the collection
            return a;
        }
    }


}
