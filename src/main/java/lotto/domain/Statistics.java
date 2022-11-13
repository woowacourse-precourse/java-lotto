package lotto.domain;


import lotto.exception.InputException;

import java.util.HashMap;
import java.util.Map;


public class Statistics {

    public static final String REG_XP_DIGITS = "^[0-9]+$";

    public final Map<LottoRank, Integer> winLottoInfo;

    private final int purchaseAmount;

    private int winAmount;

    public Statistics(String purchaseAmount) {
        winLottoInfo = new HashMap<>();
        initMap();
        hasDigitsOnly(purchaseAmount);
        int money = Integer.parseInt(purchaseAmount);
        isDividedByLottoAmount(money);
        this.purchaseAmount = money;
    }

    private void initMap() {
        for(LottoRank rank : LottoRank.values()) {
            winLottoInfo.put(rank, 0);
        }
    }

    private void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    private void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public void setLottoWinResultToMap(int matchCount, int bonusCount) {
        if (matchCount >= 3 && matchCount <= 6) {
            LottoRank rank = LottoRank.of(matchCount, bonusCount);
            winLottoInfo.put(rank, winLottoInfo.get(rank) + 1);
        }
    }

    public int findTotalWinAmount() {
        for (LottoRank rank : winLottoInfo.keySet()) {
            Integer total = winLottoInfo.get(rank);
            winAmount += rank.getMoney(total);
        }
        return winAmount;
    }

    public int getLottoPublishCount() {
        return purchaseAmount / 1000;
    }
}
