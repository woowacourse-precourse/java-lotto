package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int MIN_MATCH = 3;
    private static final int MAX_MATCH = 7;
    private static final int PURCHASE_UNIT = 1000;

    private Integer purchasePrice;

    public void getPurchasePrice(int purchasePrice) {
        if (purchasePrice % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        this.purchasePrice = purchasePrice;
    }

    public List<List<Integer>> publishPurchaseLottos() {
        List<List<Integer>> purchaseLottos = new ArrayList<>();
        int publishCount = purchasePrice / PURCHASE_UNIT;

        for (int i = 0; i < publishCount; i++) {
            purchaseLottos.add(Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_LENGTH));
        }

        return purchaseLottos;
    }

    public int[] findMatchCount(List<Integer> lotto, List<List<Integer>> purchaseLottos) {
        int[] matchCounts = new int[MAX_MATCH];

        purchaseLottos.stream()
                .mapToInt(purchaseLotto -> (int) purchaseLotto.stream().filter(lotto::contains).count())
                .forEach(matchCount -> matchCounts[matchCount] += 1);

        return Arrays.copyOfRange(matchCounts, MIN_MATCH, MAX_MATCH);
    }

}
