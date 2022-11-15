package lotto.domain;

import java.util.List;

public class WinningLotto {
    private static final String DUPLICATED = "[ERROR] 보너스 볼 번호는 당첨 번호와 중복될 수 없습니다.";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(winningNumbers);
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void validateDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    public Rank compareNumbers(Lotto lotto) {
        int matchCounts = lotto.checkMatchCounts(this.lotto);
        boolean isBonusBall = lotto.contains(bonusNumber);
        return Rank.of(matchCounts, isBonusBall);
    }
}
