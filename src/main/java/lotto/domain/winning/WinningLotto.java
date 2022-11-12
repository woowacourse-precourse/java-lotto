package lotto.domain.winning;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;

public class WinningLotto {

    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "당첨 숫자와 보너스 숫자는 중복될 수 없습니다.";

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

    public LottoResults lottoResults(List<Lotto> purchasedLottoTickets) {
        Map<LottoRanking, Integer> results = new EnumMap<>(LottoRanking.class);
        Arrays.stream(LottoRanking.values())
                .forEach(lottoRanking -> results.put(lottoRanking, 0));

        judgeWinning(purchasedLottoTickets, results);

        return new LottoResults(results);
    }

    private void judgeWinning(List<Lotto> purchasedLottoTickets,
            Map<LottoRanking, Integer> results) {
        final int MIN_NUMBER_FOR_WINNING = 3;
        for (Lotto purchasedLotto : purchasedLottoTickets) {
            int countsOfMatchingNumber = winningNumber.countsOfMatchingNumber(purchasedLotto);
            if (countsOfMatchingNumber < MIN_NUMBER_FOR_WINNING) {
                continue;
            }

            judgeLottoRankings(countsOfMatchingNumber, purchasedLotto, results);
        }
    }

    private void judgeLottoRankings(int countsOfMatchingNumber, Lotto purchasedLotto,
            Map<LottoRanking, Integer> results) {
        boolean isMatchedBonusNumber = bonusNumber.isIn(purchasedLotto);
        if (isSecondRankings(countsOfMatchingNumber, isMatchedBonusNumber)) {
            results.put(LottoRanking.SECOND, results.get(LottoRanking.SECOND) + 1);
            return;
        }

        LottoRanking lottoRanking = LottoRanking.lottoRanking(countsOfMatchingNumber);
        results.put(lottoRanking, results.get(lottoRanking) + 1);
    }

    private boolean isSecondRankings(int countsOfMatchingNumber, boolean isMatchedBonusNumber) {
        final int MATCH_NUMBER_FOR_SECOND_OR_THIRD = 5;
        return countsOfMatchingNumber == MATCH_NUMBER_FOR_SECOND_OR_THIRD
                && isMatchedBonusNumber;
    }
}
