package lotto.Model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Result {
    private final Map<Rank, Long> lottoResult;

    public Result(final User userLotto, final Winning winningLotto) {
        this.lottoResult = createLottoResult(userLotto.compareLottoNbr(winningLotto));
    }


    public Map<Rank, Long> getLottoResult() {
        return lottoResult;
    }

    private EnumMap<Rank, Long> initLottoResult() {
        return Arrays.stream(Rank.values())
                .filter(value -> value != Rank.Not_winning)
                .collect(Collectors.toMap(value -> value, count -> 0L, (a, b) -> b,
                        () -> new EnumMap<>(Rank.class)));
    }

    private Map<Rank, Long> createLottoResult(final List<Rank> lottoRanks) {
        Map<Rank, Long> lottoResult = initLottoResult();
        for (Rank lottoRank : lottoRanks) {
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }
        return lottoResult;
    }

    public Double calculateYield(final Price pay) {
        long reward = lottoResult.keySet().stream()
                .mapToLong(lottoRank -> lottoRank.getReward() * lottoResult.get(lottoRank)).sum();
        return pay.calearning(reward);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result that = (Result) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}
