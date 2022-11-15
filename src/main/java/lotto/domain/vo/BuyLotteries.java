package lotto.domain.vo;

import java.util.List;

public class BuyLottos {

    private final List<Lotto> buyLottoList;

    public BuyLottos(List<Lotto> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public List<Lotto> getBuyLottoList() {
        return buyLottoList;
    }
}
