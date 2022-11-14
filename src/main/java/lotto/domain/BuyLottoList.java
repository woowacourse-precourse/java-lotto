package lotto.domain;

import java.util.List;

public class BuyLottoList {
    List<Lotto> buyLottoList;

    public BuyLottoList(List<Lotto> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public List<Lotto> getBuyLottoList() {
        return buyLottoList;
    }
}
