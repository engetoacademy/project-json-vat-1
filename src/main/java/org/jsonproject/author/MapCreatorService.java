package org.jsonproject.author;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapCreatorService {

    public LinkedHashMap<String, Double> createBottomThreeMap(JsonFromUrlToHashMapService myJsonFromUrl) {
        return myJsonFromUrl.getCountryStandardRateMap().entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public LinkedHashMap<String, Double> createTopThreeMap(JsonFromUrlToHashMapService myJsonFromUrl) {
        return myJsonFromUrl.getCountryStandardRateMap().entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                    .limit(3)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
