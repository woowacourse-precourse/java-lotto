package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinResultManager {

    public static List<CorrectNumber> getCorrectedNumbersWithWin(List<List<Integer>> tickets,
            List<Integer> winNumbers, int bonus) {
        List<CorrectNumber> resultCollector = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            Set<Integer> matchedNumbers = ticket.stream()
                    .filter(winNumbers::contains)
                    .collect(Collectors.toSet());
            if (matchedNumbers.size() == 3) {
                resultCollector.add(CorrectNumber.THREE);
            }
            if (matchedNumbers.size() == 4) {
                resultCollector.add(CorrectNumber.FOUR);
            }
            if (matchedNumbers.size() == 5 && ticket.contains(bonus)) {
                resultCollector.add(CorrectNumber.FIVE_BONUS);
            }
            if (matchedNumbers.size() == 5 && !ticket.contains(bonus)) {
                resultCollector.add(CorrectNumber.FIVE);
            }
            if (matchedNumbers.size() == 6) {
                resultCollector.add(CorrectNumber.SIX);
            }
        }
        return resultCollector;
    }

    public static Map<CorrectNumber, Long> correctCaseCollector(List<CorrectNumber> resultCollection) {
        Map<CorrectNumber, Long> resultMap = resultCollection.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return resultMap;
    }
}
