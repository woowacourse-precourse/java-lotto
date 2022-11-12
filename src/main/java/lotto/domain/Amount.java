package lotto.domain;

import lotto.standard.Bug;
import lotto.standard.Place;

import java.util.Map;

public class Amount {
    private final static int lottoPrice = 1000;
    
    private final int inputAmount;
    private int purchasesQuantity;
    private double earningRate;

    public Amount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getPurchasesQuantity() {
        calculatePurchasesQuantity();
        return this.purchasesQuantity;
    }

    private void calculatePurchasesQuantity() {
        int purchasesQuantity = inputAmount / lottoPrice;
        if (inputAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage()
                    + Bug.AMOUNT_DIVIDED_NO_REMAINING.getMessage());
        }
        this.purchasesQuantity = purchasesQuantity;
    }

    public double getEarningRate(Map<Place, Integer> winningRanks) {
        calculateEarningRate(winningRanks);
        return earningRate;
    }

    private void calculateEarningRate(Map<Place, Integer> winningRanks) {
        int proceeds = 0;
        for (Place place : Place.values()) {
            proceeds += place.getPrizeMoney() * winningRanks.get(place);
        }
        try {
            this.earningRate = (proceeds / (double) inputAmount) * 100;

        } catch (ArithmeticException e) {
            this.earningRate = 0;
        }
    }
}
