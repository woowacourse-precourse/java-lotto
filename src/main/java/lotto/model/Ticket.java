package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final List<Lotto> lotteries;
    private final PurchaseAmount purchaseAmount;

    public Ticket(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lotteries = createLotteries(purchaseAmount);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    private List<Lotto> createLotteries(PurchaseAmount purchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = purchaseAmount.getMoney() / 1000;

        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> lottoNumbers = createLotto();
            lotteries.add(new Lotto(lottoNumbers));
        }

        return lotteries;
    }

    private static List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
