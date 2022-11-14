package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {

    private Integer purchasePrice;

    public void getPurchasePrice(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        this.purchasePrice = purchasePrice;
    }

    public List<List<Integer>> publishPurchaseLottos() {
        List<List<Integer>> purchaseLottos = new ArrayList<>();
        int publishCount = purchasePrice / 1000;

        for (int i = 0; i < publishCount; i++) {
            purchaseLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return purchaseLottos;
    }

    public int[] findMatchCount(List<Integer> lotto, List<List<Integer>> purchaseLottos) {
        int[] matchCounts = new int[7];

        purchaseLottos.stream()
                .mapToInt(purchaseLotto -> (int) purchaseLotto.stream().filter(lotto::contains).count())
                .forEach(matchCount -> matchCounts[matchCount] += 1);

        return Arrays.copyOfRange(matchCounts, 3, 8);
    }

}
