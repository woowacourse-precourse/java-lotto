package lotto.domain.winning;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.lotto_numbers.WinningNumber;

public class WinningNumbers {

    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "중복 숫자는 입력될 수 없습니다.";

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validateDuplication(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumber)) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }

    public LottoResults lottoResults(List<Lotto> purchasedLottos) {
        Map<LottoRanking, Integer> results = new LinkedHashMap<>();
        EnumSet.allOf(LottoRanking.class).forEach(lottoRanking -> results.put(lottoRanking, 0));

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCountsOfWinningNumber = winningNumber.matchCounts(purchasedLotto);
            int matchCountOfBonusNumber = 0;

            if (matchCountsOfWinningNumber == 5) {
                matchCountOfBonusNumber = bonusNumber.matchCount(purchasedLotto);
            }

            addResults(matchCountsOfWinningNumber, matchCountOfBonusNumber, results);
        }

        return new LottoResults(results);
    }

    private void addResults(int matchNumberCounts, int bonusNumberMatch,
            Map<LottoRanking, Integer> results) {
        if (matchNumberCounts < 3) {
            return;
        }

        if (matchNumberCounts == 5 && bonusNumberMatch == 1) {
            results.put(LottoRanking.SECOND, results.get(LottoRanking.SECOND) + 1);
            return;
        }

        EnumSet.allOf(LottoRanking.class).stream()
                .filter(lottoRanking -> lottoRanking.isMatchedNumberCount(matchNumberCounts))
                .forEach(lottoRanking ->
                        results.put(lottoRanking, results.get(lottoRanking) + 1));
    }
}
