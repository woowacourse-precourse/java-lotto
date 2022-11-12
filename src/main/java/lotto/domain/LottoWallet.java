package lotto.domain;

import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottoWallet;

    public LottoWallet(List<Lotto> lottoWallet) {
        this.lottoWallet = lottoWallet;
    }

    public List<Lotto> getLottoWallet() {
        return lottoWallet;
    }

}
