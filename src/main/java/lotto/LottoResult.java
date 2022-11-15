package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
    private int rateOfReturn;
    private LottoMarket lottoMarket;
    private LottoHeadOffice lottoHeadOffice;

    LottoResult() {
        this.lottoMarket = new LottoMarket();
        this.lottoHeadOffice = new LottoHeadOffice();
        tourLottos();
    }

    public void tourLottos() {
        List<Lotto> lottos = lottoMarket.getLottos();

        List<Integer> winningNum = lottoHeadOffice.getWinningNum();
        int bonusNum = lottoHeadOffice.getBonusNum();

        for (Lotto lotto : lottos) {
            compareNum(lotto.getNumbers(), winningNum, bonusNum);
        }
    }

    public void compareNum(List<Integer> user, List<Integer> winning, Integer bonus) {
        int cnt = 0;
        for (Integer integer : user) {
            if (winning.contains(integer))
                cnt++;
        }
        if (cnt == 6)
            results.set(1, results.get(1) + 1);
        if (cnt == 5 && user.contains(bonus))
            results.set(2, results.get(2) + 1);
        if (cnt == 5 && !user.contains(bonus))
            results.set(3, results.get(3) + 1);
        if (cnt == 4)
            results.set(4, results.get(4) + 1);
        if (cnt == 3)
            results.set(5, results.get(5) + 1);
        System.out.println(results);
    }

    public void printResults() {
    }

    public void calculateRateOfReturn() {
    }
}
