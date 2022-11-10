package lotto.repository;

import java.util.List;

public class LottoRepository {
    private List<List<Integer>> purchasedLotto;
    private List<Integer> winNumbers;

    public LottoRepository(List<List<Integer>> purchasedLotto) {

        this.purchasedLotto = purchasedLotto;
    }

    public List<List<Integer>> getPurchasedLotto() {
        return purchasedLotto;
    }
}
