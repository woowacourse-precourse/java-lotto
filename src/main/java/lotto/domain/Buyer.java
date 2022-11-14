package lotto.domain;

import lotto.validation.Validation;
import java.util.ArrayList;
import java.util.HashMap;

public class Buyer {
    private static final long ZERO = 0L;
    private static final double PERCENT = 100;
    private static final int LOTTO_LEAST_AMOUNT = 1_000;
    private static final int LOTTO_MAX_AMOUNT = 100_000;

    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    private final HashMap<Rank, Integer> lottoResult = new HashMap<>();
    private final int purchaseAmount;

    public Buyer(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        initLottoResult();
    }

    public void buyLotto(Lotto lotto) {
        purchasedLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotteries() {
        return purchasedLotteries;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public long getPrizeSum() {
        long sum = ZERO;
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }

    public double getYield() {
        return (getPrizeSum() / (double) purchaseAmount) * PERCENT;
    }

    private void initLottoResult() {
        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.NO_RANK_TWO, 0);
        lottoResult.put(Rank.NO_RANK_ONE, 0);
        lottoResult.put(Rank.NO_RANK_ZERO, 0);
    }

    private void validatePurchaseAmount(int amount) {
        Validation.validateMultipleNumber(amount, LOTTO_LEAST_AMOUNT);
        Validation.validateExceedNumber(amount, LOTTO_MAX_AMOUNT);
    }
}
