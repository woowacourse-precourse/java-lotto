package lotto;

import java.util.function.Predicate;

public class LottoMachine {
    private Lotto lotto;
    private Lotto winningLotto;
    private int bonusNum;

    public LottoMachine(Lotto lotto, Lotto winningLotto, int bonusNum) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public int calcAmount() {
        return getResult().value();
    }

    public LottoResult getResult() {
        if (howManyMatch(6)) {
            return LottoResult.FIRST_PLACE;
        }
        if (howManyMatch(5) && lotto.getNumbers().contains(bonusNum)) {
            return LottoResult.SECOND_PLACE;
        }
        if (howManyMatch(5) && !lotto.getNumbers().contains(bonusNum)) {
            return LottoResult.THIRD_PLACE;
        }
        if (howManyMatch(4)) {
            return LottoResult.FOURTH_PLACE;
        }
        if (howManyMatch(3)) {
            return LottoResult.FIFTH_PLACE;
        }
        return LottoResult.LAST_PLACE;
    }

    private boolean howManyMatch(int count) {
        return lotto
                .getNumbers()
                .stream()
                .filter(num -> winningLotto.getNumbers().stream().anyMatch(Predicate.isEqual(num)))
                .count() == count;
    }
}
