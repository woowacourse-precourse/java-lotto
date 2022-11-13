package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final List<Lotto> lotteries;
    private final int purchaseAmount;

    public Ticket(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lotteries = createLotteries(purchaseAmount);
    }

    public Ticket(List<Lotto> lotteries, int purchaseAmount) {
        this.lotteries = lotteries;
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private List<Lotto> createLotteries(int purchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = purchaseAmount / 1000;

        for (int count = 1; count <= lottoCount; count++) {
            lotteries.add(Lotto.createLotto());
        }

        return lotteries;
    }

    private void validatePurchaseAmount(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
