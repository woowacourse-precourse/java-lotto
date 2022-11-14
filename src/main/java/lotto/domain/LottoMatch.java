package lotto.domain;

import java.util.function.Predicate;

public class LottoMatch {
    public static int countMatch(final Lotto lotto, final Lotto winningNumber) {
        return (int) lotto.get()
                .stream()
                .filter(number -> winningNumber.get()
                        .stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }
}
