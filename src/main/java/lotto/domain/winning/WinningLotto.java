package lotto.domain.winning;

import java.util.EnumSet;
import java.util.LinkedHashMap;
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
        Map<LottoRanking, Integer> results = new LinkedHashMap<>();
        EnumSet.allOf(LottoRanking.class)
                .forEach(lottoRanking -> results.put(lottoRanking, 0));

        judgeWinning(purchasedLottos, results);

        return new LottoResults(results);
    }

    private void judgeWinning(List<Lotto> purchasedLottos, Map<LottoRanking, Integer> results) {
        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCountsOfWinningNumber = winningNumber.matchNumberCounts(purchasedLotto);
            if (matchCountsOfWinningNumber < 3) {
                continue;
            }

            int matchCountOfBonusNumber = 0;
            if (matchCountsOfWinningNumber == 5) {
                matchCountOfBonusNumber = bonusNumber.matchCount(purchasedLotto);
            }

            addResults(matchCountsOfWinningNumber, matchCountOfBonusNumber, results);
        }
    }

    private void addResults(int matchCountsOfWinningNumber, int matchCountOfBonusNumber,
            Map<LottoRanking, Integer> results) {
        if (isSecondRankings(matchCountsOfWinningNumber, matchCountOfBonusNumber)) {
            results.put(LottoRanking.SECOND, results.get(LottoRanking.SECOND) + 1);
            return;
        }

        matchRankings(matchCountsOfWinningNumber, results);
    }

    private void matchRankings(int matchCountsOfWinningNumber, Map<LottoRanking, Integer> results) {
        // count 개수가 동일하고, bonus는 false인 랭킹 검색
        EnumSet.allOf(LottoRanking.class).stream()
                .filter(lottoRanking ->
                        lottoRanking.isMatchedOnlyNumberCount(matchCountsOfWinningNumber))
                .forEach(lottoRanking ->
                        results.put(lottoRanking, results.get(lottoRanking) + 1));  // 검색된 랭킹의 value + 1
    }

    private boolean isSecondRankings(int matchNumberCounts, int bonusNumberMatch) {
        return matchNumberCounts == 5 && bonusNumberMatch == 1;
    }
}
