package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.domain.enums.NumbersType;

public class LottoCheck {
    public LottoCheck() {
    }

    public int checkWinning(List<Integer> winningNumbers, List<Integer> numbers) {
        List<Integer> noneDuplication = numbers.stream()
                .filter(number -> winningNumbers.stream().noneMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());
        return NumbersType.NUMBERS_SIZE.getValue() - noneDuplication.size();
    }

    public boolean checkBonus(int bonus, List<Integer> numbers) {
        return numbers.contains(bonus);
    }

    public String checkRanking(List<Integer> winningNumbers, List<Integer> numbers, int bonus) {
        if (checkWinning(winningNumbers, numbers) == NumbersType.NUMBERS_SIZE.getValue()) {
            return "FIRST";
        }
        if (checkWinning(winningNumbers, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 1 && checkBonus(bonus, numbers)) {
            return "SECOND";
        }
        if (checkWinning(winningNumbers, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 1 && !checkBonus(bonus, numbers)) {
            return "THIRD";
        }
        if (checkWinning(winningNumbers, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 2) {
            return "FOURTH";
        }
        if (checkWinning(winningNumbers, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 3) {
            return "FIFTH";
        }
        return null;
    }
}