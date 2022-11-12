package lotto.domain.winning;

import static lotto.domain.winning.Ranking.ranking;
import static lotto.domain.winning.Ranking.values;

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
        Map<Ranking, Integer> results = initializedRankingMap();
        judgeRanking(purchasedLottoTickets, results);  // TODO 메서드 이름 고민

        return new LottoResults(results);
    }

    private Map<Ranking, Integer> initializedRankingMap() {
        Map<Ranking, Integer> results = new EnumMap<>(Ranking.class);
        Arrays.stream(values())
                .forEach(ranking -> results.put(ranking, 0));

        return results;
    }

    private void judgeRanking(List<Lotto> purchasedLottoTickets, Map<Ranking, Integer> results) {
        final int MIN_NUMBER_FOR_WINNING = 3;
        for (Lotto purchasedLotto : purchasedLottoTickets) {
            int countsOfMatchingNumber = winningNumber.countsOfMatchingNumber(purchasedLotto);
            if (countsOfMatchingNumber < MIN_NUMBER_FOR_WINNING) {
                continue;
            }

            boolean isMatchedBonusNumber = bonusNumber.isIn(purchasedLotto);
            Ranking ranking = ranking(countsOfMatchingNumber, isMatchedBonusNumber);

            results.put(ranking, results.get(ranking) + 1);
        }
    }
}
