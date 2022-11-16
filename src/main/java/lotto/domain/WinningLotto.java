package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Rank getResult(Lotto lotto) {
        int countOfMatches = lotto.countMatchingNumbers(this.lotto);
        boolean containsBonusNumber = lotto.contains(bonusNumber);

        return Rank.of(countOfMatches, containsBonusNumber);
    }
}
