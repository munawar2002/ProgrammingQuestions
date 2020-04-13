package com.java.programs.others;

import java.util.*;

/**
 * Created by sheik on 10/28/2017.
 */
public class UniqueNumbers {

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {

        Set<Integer> distincts = new TreeSet();
        distincts.addAll(numbers);

        List<Integer> uniques = new ArrayList();

        uniques.addAll(distincts);

        return uniques;

    }

//
//    public static Collection<Integer> findUniqueNumbers2(Collection<Integer> numbers) {
//
//        List<Integer> mapIntegers = new ArrayList();
//        List<Integer> repeated = new ArrayList();
//        for (int num : numbers) {
//            if (mapIntegers.contains(num)) {
//                System.out.println("as : "+num);
//                mapIntegers.remove(new Integer(num));
//                repeated.add(num);
//            }else if(!repeated.contains(num)){
//                System.out.println("bs : "+num);
//                mapIntegers.add(num);
//            }
//        }
//
//List<Integer> uniques = new ArrayList();
//
//        for (Map.Entry<Integer, Integer> entry : mapIntegers.ent())
//        {
//            if(entry.getData()==1){
//                uniques.add(entry.getKey());
//            }
//        }
//
//        return uniques;
//    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 1, 1, 3);
//        for (int number : findUniqueNumbers2(numbers))
//            System.out.println(number);
    }

//    public static void main(String[] args) {
//        Integer[] numbers = {1, 1, 2, 1, 3, 4, 5};
//        Set<Integer> distinct = new TreeSet();
//        distinct.addAll(Arrays.asList(numbers));
//
//        System.out.println("uniqKeys: " + distinct);
//
//    }
}
