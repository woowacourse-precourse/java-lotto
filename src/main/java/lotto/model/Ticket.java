package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final List<Lotto> lotteries;
    private final PurchaseAmount purchaseAmount;

    public Ticket(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        List<Lotto> lotteries = createLotteries(purchaseAmount);
        validateLotteries(lotteries);
        this.lotteries = lotteries;
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

    private void validateLotteries(List<Lotto> lotteries) {
        if (lotteries.size() != purchaseAmount.getMoney() / 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 발행 개수가 올바르지 않습니다.");
        }
    }
}
