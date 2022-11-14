package lotto.domain.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<LottoRank, Long> lottoResult;

    public LottoResult() {
        this.lottoResult = initLottoResult();
    }

    public LottoResult(final UserLotto userLotto, final WinningLotto winningLotto) {
        this.lottoResult = createLottoResult(userLotto.compareLottoNumber(winningLotto));
    }
    public LottoResult(final Map<LottoRank, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<LottoRank, Long> getLottoResult() {
        return lottoResult;
    }

    private EnumMap<LottoRank, Long> initLottoResult() {
        return Arrays.stream(LottoRank.values())
                .filter(value -> value != LottoRank.NO_MATCH)
                .collect(Collectors.toMap(value -> value, count -> 0L, (a, b) -> b,
                        () -> new EnumMap<>(LottoRank.class)));
    }

    private Map<LottoRank, Long> createLottoResult(final List<LottoRank> lottoRanks) {
        Map<LottoRank, Long> lottoResult = initLottoResult();
        for (LottoRank lottoRank : lottoRanks) {
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }
        return lottoResult;
    }

    public Double calculateYield(final Pay pay) {
        long reward = lottoResult.keySet().stream()
                .mapToLong(lottoRank -> lottoRank.getReward() * lottoResult.get(lottoRank)).sum();
        return pay.calculateYield(reward);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}
