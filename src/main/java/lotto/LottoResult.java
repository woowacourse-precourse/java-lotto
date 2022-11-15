package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
    private double revenue = 0;
    private LottoMarket lottoMarket;
    private LottoHeadOffice lottoHeadOffice;

    LottoResult() {
        this.lottoMarket = new LottoMarket();
        this.lottoHeadOffice = new LottoHeadOffice();
        tourLottos();
        printResults();
    }

    private void tourLottos() {
        List<Lotto> lottos = lottoMarket.getLottos();

        List<Integer> winningNum = lottoHeadOffice.getWinningNum();
        int bonusNum = lottoHeadOffice.getBonusNum();

        for (Lotto lotto : lottos) {
            compareNum(lotto.getNumbers(), winningNum, bonusNum);
        }
    }

    private void compareNum(List<Integer> user, List<Integer> winning, Integer bonus) {
        int cnt = 0;
        for (Integer integer : user) {
            if (winning.contains(integer))
                cnt++;
        }
        if (cnt == 6) {
            results.set(1, results.get(1) + 1);
            revenue += 2_000_000_000;
        }
        if (cnt == 5 && user.contains(bonus)) {
            results.set(2, results.get(2) + 1);
            revenue += 30_000_000;
        }
        if (cnt == 5 && !user.contains(bonus)) {
            results.set(3, results.get(3) + 1);
            revenue += 1_500_000;
        }
        if (cnt == 4) {
            results.set(4, results.get(4) + 1);
            revenue += 50_000;
        }
        if (cnt == 3) {
            results.set(5, results.get(5) + 1);
            revenue += 5_000;
        }
    }

    private void printResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(5));
        System.out.println("4개 일치 (50,000원) - " + results.get(4));
        System.out.println("5개 일치 (1,500,000원) - " + results.get(3));
        System.out.println("5개 일치, 보너스 볼 일치 (30,500,000원) - " + results.get(2));
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(1));
        System.out.println("총 수익률은 " + calculateRateOfReturn() + "입니다.");
    }

    private double calculateRateOfReturn() {
        double cost = lottoMarket.getPurchasePrice();
        double rateOfReturn = (revenue / cost) * 100.0;

        return Math.round(rateOfReturn * 10) / 10.0;
    }
}
