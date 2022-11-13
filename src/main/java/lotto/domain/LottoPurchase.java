package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    public List<Lotto> lottery;

    public LottoPurchase() {
	this.lottery = new ArrayList<>();
    }

    public void purchaseLottery(List<Lotto> lottery) {
	this.lottery = lottery;
    }

    public List<Lotto> getLottery() {
	return lottery;
    }
}
