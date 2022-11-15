package lotto;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.List;

import static lotto.enums.LottoCondition.BOUND_END;
import static lotto.enums.LottoCondition.BOUND_START;

public class LottoGame {
    private final Integer bonusNumber;
    private final GameLottos gameLottos;

    public LottoGame(Integer bonusNumber, Lotto winningLotto, List<Lotto> publishedLottos) {
        this.bonusNumber = bonusNumber;
        this.gameLottos = new GameLottos(winningLotto, publishedLottos);
        this.validateBonusNumber(bonusNumber);
    }

    public LottoResult generateResult() {
        List<Rank> ranks = gameLottos.calculateResultRanks(bonusNumber);
        EnumMap<Rank, Integer> ranksResult = new EnumMap<>(Rank.class);

        for (Rank rank : ranks) {
            ranksResult.put(rank, ranksResult.getOrDefault(rank, 0) + 1);
        }

        return new LottoResult(ranksResult);
    }

    private void validateBonusNumber(Integer bonusNumber) throws IllegalArgumentException {
        validateBonusNumberNotInWinningLotto(bonusNumber);
        validateBonusNumberInBound(bonusNumber);
    }

    private void validateBonusNumberNotInWinningLotto(Integer bonusNumber) throws IllegalArgumentException {
        if (gameLottos.isWinningLottoContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateBonusNumberInBound(Integer bonusNumber) throws IllegalArgumentException {
        if (((BOUND_START.getNumber() <= bonusNumber) && (bonusNumber <= BOUND_END.getNumber())) == false) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 또한 1-45범위의 숫자여야 합니다.");
        }
    }
}
