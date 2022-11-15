package lotto;

import static lotto.Lotto.MAX_NUMBER;
import static lotto.Lotto.MIN_NUMBER;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winnerLotto, int bonusNumber) {
        if (winnerLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber >= MIN_NUMBER && MAX_NUMBER >= bonusNumber) {
            return;
        }
        throw new IllegalArgumentException("보너스 번호는 1부터 45까지의 숫자만 가능합니다.");
    }

    public WinningLotto lottoResult(Lottos lottos) {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = rankOf(lotto);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return new WinningLotto(lottoResult);
    }

    private Rank rankOf(Lotto lotto) {
        return Rank.of(winningLotto.matchCount(lotto), lotto.hasBonusNumber(bonusNumber));
    }
}
