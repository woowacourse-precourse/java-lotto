package lotto.domain;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<Lotto> resultLottery;

    public LottoResult(List<Lotto> resultLottery) {
        this.resultLottery = resultLottery;

    }

    public int getLotteryCount() {
        return resultLottery.size();
    }

    public List<Lotto> getLottoResult() {
        return Collections.unmodifiableList(resultLottery);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(resultLottery, that.resultLottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultLottery);
    }
}
