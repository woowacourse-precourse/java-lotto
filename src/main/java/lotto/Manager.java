package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private Integer purchasePrice;

    public void setPurchasePrice(int purchasePrice) {
        if (purchasePrice % LottoConst.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        this.purchasePrice = purchasePrice;
    }

    public List<List<Integer>> publishPurchaseLottos() {
        List<List<Integer>> purchaseLottos = new ArrayList<>();
        int publishCount = purchasePrice / LottoConst.PURCHASE_UNIT;

        for (int i = 0; i < publishCount; i++) {
            purchaseLottos.add(Randoms.pickUniqueNumbersInRange(LottoConst.START_RANGE, LottoConst.END_RANGE, LottoConst.LOTTO_LENGTH));
        }

        return purchaseLottos;
    }

    public int[] findMatchCount(List<Integer> lotto, List<List<Integer>> purchaseLottos) {
        int[] matchCounts = new int[LottoConst.MAX_MATCH];

        purchaseLottos.stream()
                .mapToInt(purchaseLotto -> (int) purchaseLotto.stream().filter(lotto::contains).count())
                .forEach(matchCount -> matchCounts[matchCount] += 1);

        return Arrays.copyOfRange(matchCounts, LottoConst.MIN_MATCH, LottoConst.MAX_MATCH);
    }

    public double calculator(int[] matchCounts) {
        double totalWinnings = 0;
        totalWinnings += matchCounts[0] * LottoConst.WINNING_MATCH_3;
        totalWinnings += matchCounts[1] * LottoConst.WINNING_MATCH_4;
        totalWinnings += matchCounts[2] * LottoConst.WINNING_MATCH_5;
        totalWinnings += matchCounts[3] * LottoConst.WINNING_MATCH_5_AND_BONUS;
        totalWinnings += matchCounts[4] * LottoConst.WINNING_MATCH_6;
        return Math.round(totalWinnings * 1000 / (double) purchasePrice) / (double) 10;
    }
}
