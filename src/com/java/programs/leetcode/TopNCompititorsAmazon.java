package com.java.programs.leetcode;

import java.util.*;

public class TopNCompititorsAmazon {

    public ArrayList<String> topNCompetitors(int topNCompetitors,
                                             List<String> competitors,
                                             List<String> reviews) {

        Map<String,Integer> competitorsMap = new HashMap<>();

        competitors.forEach(competitor -> competitorsMap.put(competitor.toLowerCase(),0));

        for(String review : reviews){
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(review.split("[\\s,;.]+")));
            for(String word : uniqueWords){
                competitorsMap.computeIfPresent(word.toLowerCase(), (k,v) -> v+1);
            }
        }
        // two level sorting, first by value(integer) then by key(lexicographically).
        Comparator<Map.Entry<String, Integer>> comparatorByValueAndKey = getComparatorByValueAndKey();
        System.out.println(competitorsMap);
        ArrayList<String> topNCompetitorsArray = new ArrayList<>();
        competitorsMap.entrySet()
                .stream()
                .sorted(comparatorByValueAndKey)
                .limit(topNCompetitors)
                .forEach(entry -> topNCompetitorsArray.add(entry.getKey()));

        return topNCompetitorsArray;
    }

    private Comparator<Map.Entry<String, Integer>> getComparatorByValueAndKey() {
        Comparator<Map.Entry<String,Integer>> comparatorByValue = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Comparator<Map.Entry<String,Integer>> comparatorByKey = Map.Entry.comparingByKey();
        return comparatorByValue.thenComparing(comparatorByKey);
    }

    public static void main(String[] args) {
        TopNCompititorsAmazon test = new TopNCompititorsAmazon();

        List<String> competitors = new ArrayList<>(Arrays.asList(
                "anacell", "betacellular", "cetracular", "deltacellular", "eurocell"));
        List<String> reviews = new ArrayList<>(Arrays.asList(
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."));

        System.out.println("Top N Compititors are : "+test.topNCompetitors( 2, competitors, reviews));
    }


}
