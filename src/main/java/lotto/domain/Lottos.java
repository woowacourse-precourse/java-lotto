package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult result(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        setLottoResult(winningLotto, lottoResult);
        return lottoResult;
    }

    private void setLottoResult(WinningLotto winningLotto, LottoResult lottoResult) {
        lottos.stream()
                .map(winningLotto::rank)
                .forEach(lottoResult::addResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }
}
