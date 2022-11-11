package lotto.domain.winning;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;

public class WinningLotto {

    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "중복 숫자는 입력될 수 없습니다.";

    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, BonusNumber bonusNumber) {
        validateDuplication(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(Lotto winningNumber, BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumber)) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }

    public LottoResults lottoResults(List<Lotto> purchasedLottos) {
        Map<LottoRanking, Integer> results = new EnumMap<>(LottoRanking.class);
        EnumSet.allOf(LottoRanking.class)
                .forEach(lottoRanking -> results.put(lottoRanking, 0));

        judgeWinning(purchasedLottos, results);

        return new LottoResults(results);
    }

    private void judgeWinning(List<Lotto> purchasedLottos, Map<LottoRanking, Integer> results) {
        for (Lotto purchasedLotto : purchasedLottos) {
            final int MIN_NUMBER_FOR_WINNING = 3;
            int matchCountsOfNumber = winningNumber.matchNumberCounts(purchasedLotto);
            if (matchCountsOfNumber < MIN_NUMBER_FOR_WINNING) {
                continue;
            }

            int matchCountOfBonusNumber = 0;
            if (matchCountsOfNumber == 5) {
                matchCountOfBonusNumber = bonusNumber.matchCount(purchasedLotto);
            }

            addResults(matchCountsOfNumber, matchCountOfBonusNumber, results);
        }
    }

    private void addResults(int matchCountsOfNumber, int matchCountOfBonusNumber,
            Map<LottoRanking, Integer> results) {
        if (isSecondRankings(matchCountsOfNumber, matchCountOfBonusNumber)) {
            results.put(LottoRanking.SECOND, results.get(LottoRanking.SECOND) + 1);
            return;
        }

        matchRankings(matchCountsOfNumber, results);
    }

    private void matchRankings(int matchCountsOfNumber, Map<LottoRanking, Integer> results) {
        LottoRanking lottoRanking = LottoRanking.lottoRanking(matchCountsOfNumber);
        results.put(lottoRanking, results.get(lottoRanking) + 1);
    }

    private boolean isSecondRankings(int matchCountsOfNumber, int matchCountOfBonusNumber) {
        return matchCountsOfNumber == 5 && matchCountOfBonusNumber == 1;
    }
}
