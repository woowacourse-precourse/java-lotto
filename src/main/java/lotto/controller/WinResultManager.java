package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.controller.Constants.LEAST_WIN_NUMBER;

public class WinResultManager {
    public static List<Integer> getCorrectedNumbersWithWin(List<List<Integer>> tickets, List<Integer> answer) {
        List<Integer> resultCollection = new ArrayList<>();
        for(List<Integer> ticket : tickets) {
            Set<Integer> matchedNumbers = ticket.stream()
                    .filter(answer::contains)
                    .collect(Collectors.toSet());
            resultCollection.add(matchedNumbers.size());
        }
        return resultCollection;
    }
}
