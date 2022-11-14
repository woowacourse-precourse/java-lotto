package lotto.domain.vo;

import java.util.List;

public class BuyLottoList {

    private final List<Lotto> buyLottoList;

    public BuyLottoList(List<Lotto> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public List<Lotto> getBuyLottoList() {
        return buyLottoList;
    }
}
