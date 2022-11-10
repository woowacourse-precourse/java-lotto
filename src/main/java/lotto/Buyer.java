package lotto;

import java.util.List;

public class Buyer {
    private List<Lotto> holdingLotto;

    public void purchase(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        // TODO : LotteryVendor에게 요청
    }
}