package lotto.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.Lotto;

public class WinResultManager {
    public static int returnCorrectNumber(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        return (int) lottoNumbers.stream()
                .filter(target -> winNumbers.stream().anyMatch(Predicate.isEqual(target)))
                .count();
    }
}
