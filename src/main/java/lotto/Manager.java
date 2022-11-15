package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private Integer purchasePrice;

    public void getPurchasePrice(int purchasePrice) {
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

}
