package lotto.domain.lotto;

import lotto.domain.statistics.Rank;
import lotto.global.message.ErrorMessage;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto winningLotto, BonusBall bonusBall) {
        validate(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto create(Lotto winningLotto, BonusBall bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public Rank calculateRank(Lotto lotto) {
        final int match = (int) lotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
        final boolean hasBonus = lotto.contains(bonusBall.getNumber());
        return Rank.from(match, hasBonus);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }

    private void validate(Lotto lotto, BonusBall bonusBall) {
        if (lotto.getNumbers().contains(bonusBall.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }
    }
}
