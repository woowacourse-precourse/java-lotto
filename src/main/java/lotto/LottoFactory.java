package lotto;

import java.util.List;
import java.util.Map;

public class LottoFactory {
    private int money;
    private int lottoCount;
    private List<Lotto> lottos;
    private int winMoney;

    LottoFactory() {
        money = 0;
        lottoCount = 0;
        lottos = null;
        winMoney = 0;
    }

    public void setMoney(int moneyInput) {
        this.money = moneyInput;
    }

    public void setLottoCount() {
        lottoCount = money / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setLottos(List<Lotto> buyerLottos) {
        lottos = buyerLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinmoney(Map<LottoRanking, Integer> lottoRanking) {

        LottoRanking[] values = LottoRanking.values();
        for (LottoRanking value : values) {
            if (lottoRanking.get(value) == null)
                continue;
            int winCount = lottoRanking.get(value);
            if (winCount != 0) {
                winMoney += value.getLottoRankingMoney() * winCount;
            }
        }

    }

    public int getWinMoney() {
        return this.winMoney;
    }

    public int getMoney() {
        return this.money;
    }
}
