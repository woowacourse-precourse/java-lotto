package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static lotto.controller.Constants.LEAST_WIN_NUMBER;

public class WinResultManager {

    public static CorrectNumber returnCorrectNumber(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        List<CorrectNumber> correctNumberList = new ArrayList<>(Arrays.asList(CorrectNumber.values()));
        int matchedNumber = (int) lottoNumbers.stream()
                .filter(target -> winNumbers.stream().anyMatch(Predicate.isEqual(target)))
                .count();
        for(CorrectNumber correctNumber : correctNumberList) {
            if (matchedNumber >= LEAST_WIN_NUMBER && correctNumber.getCorrectNumber() == matchedNumber) {
                return correctNumber;
            }
        }
        return CorrectNumber.LESS_THAN_THREE;
    }
}
