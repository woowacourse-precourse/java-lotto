package lotto.model;

import java.util.List;

public class BuyingLottoList {

    private final List<Lotto> lottoList;

    public BuyingLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
