package lotto.domain;

import lotto.Lotto;
import lotto.LottoRank;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Consumer {
    private final static int PURCHASE_UNIT = 1000;
    private List<Lotto> lotteries;
    private final HashMap<LottoRank, Integer> rankStatics = new HashMap<>();

    public Consumer() {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankStatics.put(lottoRank, 0);
        }
    }

    public void purchaseLotto() {
        int purchasePrice = new InputView().readPurchasePrice();
        validatePrice(purchasePrice);
        this.lotteries = getLotteries(purchasePrice);
    }

    private void validatePrice(int price) {
        if (price < PURCHASE_UNIT || price % PURCHASE_UNIT != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다. (최소 금액 1,000원)");
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> getLotteries(int purchasePrice) {
        List<Lotto> lotteries = new ArrayList<>();
        LotteryWheel lotteryWheel = new LotteryWheel();

        while (purchasePrice > 0) {
            Lotto lotto = new Lotto(lotteryWheel.generateLotteryNumbers());
            lotteries.add(lotto);
            purchasePrice -= PURCHASE_UNIT;
        }

        return lotteries;
    }

    public List<Lotto> lotteries() {
        return lotteries;
    }

    public void rankLotteries(Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lotteries) {
            int matchCount = lotto.getMatchCountWith(winningLotto);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            Arrays.stream(LottoRank.values())
                    .filter(lottoRank -> lottoRank.matchNumberCount == matchCount)
                    .filter(lottoRank -> lottoRank.hasBonusNumber == hasBonusNumber)
                    .forEach(lottoRank -> {
                       rankStatics.put(lottoRank, this.rankStatics.get(lottoRank));
                    });
        }
    }
}
