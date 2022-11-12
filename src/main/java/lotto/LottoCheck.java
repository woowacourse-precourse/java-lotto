package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCheck {
    private static final int LOTTO_SIZE = 6;

    public LottoCheck() {
    }

    public int checkWinning(List<Integer> winnings, List<Integer> numbers) {
        List<Integer> duplicate = numbers.stream()
                .filter(number -> winnings.stream().noneMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());
        return LOTTO_SIZE - duplicate.size();
    }

    public boolean checkBonus(int bonus, List<Integer> numbers) {
        return numbers.contains(bonus);
    }

    public String checkRanking(List<Integer> winnings, List<Integer> numbers, int bonus) {
        if (checkWinning(winnings, numbers) == LOTTO_SIZE) {
            return "FIRST";
        }
        if (checkWinning(winnings, numbers) == LOTTO_SIZE - 1 && checkBonus(bonus, numbers)) {
            return "SECOND";
        }
        if (checkWinning(winnings, numbers) == LOTTO_SIZE - 1 && !checkBonus(bonus, numbers)) {
            return "THIRD";
        }
        if (checkWinning(winnings, numbers) == LOTTO_SIZE - 2) {
            return "FOURTH";
        }
        if (checkWinning(winnings, numbers) == LOTTO_SIZE - 3) {
            return "FIFTH";
        }
        return null;
    }
}