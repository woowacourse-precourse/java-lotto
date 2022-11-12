package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

    public void addResult(Rank rank) {
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
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
