package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (!Lotto.isValidNumber(bonusNumber) || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Rank getRankof(Lotto lotto) {
        int matchCount = lotto.calculateMatchCount(winningNumbers);
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        for (Rank rank : Rank.values()) {
            if (rank.hasSameRankBy(matchCount, hasBonusNumber)) {
                return rank;
            }
        }
        return null;
    }

}
