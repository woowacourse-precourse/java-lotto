package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private List<Integer> results;
    private int rateOfReturn;
    private LottoMarket lottoMarket;
    private LottoHeadOffice lottoHeadOffice;

    LottoResult() {
        this.lottoMarket = new LottoMarket();
        this.lottoHeadOffice = new LottoHeadOffice();
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
    }

    public void printResults() {
    }

    public void calculateRateOfReturn() {
    }
}
