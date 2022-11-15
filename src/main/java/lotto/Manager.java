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

        System.out.println(publishCount+"개를 구매했습니다.");

        for (int i = 0; i < publishCount; i++) {
            List<Integer> publishLotto = Randoms.pickUniqueNumbersInRange(LottoConst.START_RANGE, LottoConst.END_RANGE, LottoConst.LOTTO_LENGTH);
            System.out.println(publishLotto);
            purchaseLottos.add(publishLotto);
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
        totalWinnings += matchCounts[0] * WinningPrice.MATCH_3.getPrice();
        totalWinnings += matchCounts[1] * WinningPrice.MATCH_4.getPrice();
        totalWinnings += matchCounts[2] * WinningPrice.MATCH_5.getPrice();
        totalWinnings += matchCounts[3] * WinningPrice.MATCH_5_AND_BONUS.getPrice();
        totalWinnings += matchCounts[4] * WinningPrice.MATCH_6.getPrice();
        return Math.round(totalWinnings * 1000 / (double) purchasePrice) / (double) 10;
    }
}
