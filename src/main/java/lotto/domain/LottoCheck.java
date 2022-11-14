package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.domain.enums.NumbersType;

public class LottoCheck {
    public LottoCheck() {
    }

    public int checkWinning(List<Integer> winnings, List<Integer> numbers) {
        List<Integer> duplicate = numbers.stream()
                .filter(number -> winnings.stream().noneMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());
        return NumbersType.NUMBERS_SIZE.getValue() - duplicate.size();
    }

    public boolean checkBonus(int bonus, List<Integer> numbers) {
        return numbers.contains(bonus);
    }

    public String checkRanking(List<Integer> winnings, List<Integer> numbers, int bonus) {
        if (checkWinning(winnings, numbers) == NumbersType.NUMBERS_SIZE.getValue()) {
            return "FIRST";
        }
        if (checkWinning(winnings, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 1 && checkBonus(bonus, numbers)) {
            return "SECOND";
        }
        if (checkWinning(winnings, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 1 && !checkBonus(bonus, numbers)) {
            return "THIRD";
        }
        if (checkWinning(winnings, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 2) {
            return "FOURTH";
        }
        if (checkWinning(winnings, numbers) == NumbersType.NUMBERS_SIZE.getValue() - 3) {
            return "FIFTH";
        }
        return null;
    }
}