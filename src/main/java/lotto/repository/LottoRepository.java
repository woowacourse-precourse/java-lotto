package lotto.repository;

import lotto.Lotto;

import java.util.List;

public class LottoRepository {
    private List<Lotto> purchasedLotto;
    private List<Integer> winNumbers;

    public LottoRepository(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
