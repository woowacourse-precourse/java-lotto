package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResult {
    private final List<Rank> lottoResult;

    public LottoResult(WinningLotto winningLotto, List<Lotto> lottos) {
        this.lottoResult = lottos.stream()
                .map(winningLotto::rank)
                .collect(Collectors.toList());
    }

    public Money reward() {
        return Rank.totalReward(lottoResult);
    }

    public int rankCount(Rank rank) {
        return Long.valueOf(this.lottoResult.stream()
                .filter(rank::equals)
                .count()).intValue();
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
}
