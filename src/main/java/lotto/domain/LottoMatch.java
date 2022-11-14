package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LottoMatch {
    public static List<Integer> putMatchNumbers(final List<Lotto> allLotto, final Lotto winningNumber) {
        List<Integer> matchNumbers = new ArrayList<>();
        for (Lotto lotto : allLotto) {
            matchNumbers.add(countMatch(lotto, winningNumber));
        }
        return matchNumbers;
    }

    public static int countMatch(final Lotto lotto, final Lotto winningNumber) {
        return (int) lotto.get()
                .stream()
                .filter(number -> winningNumber.get()
                        .stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public static List<Boolean> putBonus(final List<Lotto> allLotto, final BonusNumber bonusNumber) {
        List<Boolean> bonus = new ArrayList<>();
        for (Lotto lotto : allLotto) {
            bonus.add(matchBonus(lotto, bonusNumber));
        }
        return bonus;
    }

    private static boolean matchBonus(final Lotto lotto, final BonusNumber bonusNumber) {
        return lotto.get()
                .stream()
                .anyMatch(number -> bonusNumber.get()
                        .contains(number));
    }
}
