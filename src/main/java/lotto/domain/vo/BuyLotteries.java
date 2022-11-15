package lotto.domain.vo;

import java.util.List;

public class BuyLotteries {

    private final List<Lotto> buyLotteries;

    public BuyLotteries(List<Lotto> buyLotteries) {
        this.buyLotteries = buyLotteries;
    }

    public List<Lotto> getBuyLotteries() {
        return buyLotteries;
    }
}
