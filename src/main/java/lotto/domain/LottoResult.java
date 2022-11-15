package lotto.domain;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class LottoResult {
    private final Map<Rank, Integer> lottoResults;

    public LottoResult(Map<Rank, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResult calculateLottoResult(Lottos lottos, Lotto winningNumber, LottoNumber bonusNumber) {
        final Map<Rank, Integer> lottoResult = lottos.getLottos().stream()
                .collect(groupingBy((lotto) -> lotto.matchRank(winningNumber, bonusNumber), summingInt(value -> 1)));
        return new LottoResult(lottoResult);
    }

    public double calculateLottoProfit(LottoMoney money) {
        System.out.println(calculateTotalReward());
        return (double) calculateTotalReward() / money.getMoney() * 100;
    }

    private int calculateTotalReward() {
        return lottoResults.entrySet().stream()
                .map(lottoResult -> lottoResult.getKey().getReward() * lottoResult.getValue())
                .reduce(0, Integer::sum);
    }

    public Map<Rank, Integer> getLottoResult() {
        return this.lottoResults;
    }
}
