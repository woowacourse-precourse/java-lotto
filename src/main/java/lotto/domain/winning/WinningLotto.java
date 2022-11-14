package lotto.domain.winning;

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

    public LottoResults lottoResults(LottoTickets lottoTickets) {
        List<Ranking> rankings = lottoTickets.rankings(winningNumber, bonusNumber);
        Map<Ranking, Integer> results = initializedRankingMap();
        addResults(rankings, results);

        return new LottoResults(results);
    }

    private Map<Ranking, Integer> initializedRankingMap() {
        Map<Ranking, Integer> results = new EnumMap<>(Ranking.class);
        Arrays.stream(values())
                .forEach(ranking -> results.put(ranking, 0));

        return results;
    }

    private void addResults(List<Ranking> rankings, Map<Ranking, Integer> results) {
        rankings.forEach(ranking ->
                results.put(ranking, results.get(ranking) + 1));
    }

    private void validateDuplication(Lotto winningNumber, BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumber)) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
