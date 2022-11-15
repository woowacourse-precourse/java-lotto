package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinResultManager {

    public static List<CorrectNumber> getCorrectedNumbersWithWin(List<List<Integer>> tickets,
            List<Integer> answer, int bonus) {
        List<CorrectNumber> resultCollection = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            Set<Integer> matchedNumbers = ticket.stream()
                    .filter(answer::contains)
                    .collect(Collectors.toSet());
            if (matchedNumbers.size() == 3) {
                resultCollection.add(CorrectNumber.THREE);
            }
            if (matchedNumbers.size() == 4) {
                resultCollection.add(CorrectNumber.FOUR);
            }
            if (matchedNumbers.size() == 5 && ticket.contains(bonus)) {
                resultCollection.add(CorrectNumber.FIVE_BONUS);
            }
            if (matchedNumbers.size() == 5 && !ticket.contains(bonus)) {
                resultCollection.add(CorrectNumber.FIVE);
            }
            if (matchedNumbers.size() == 6) {
                resultCollection.add(CorrectNumber.SIX);
            }
        }
        return resultCollection;
    }


}
