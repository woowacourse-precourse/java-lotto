package lotto;

import java.util.List;
import java.util.Map;

public class Buyer {
    private int money;
    private int lottoCount;
    private List<Lotto> lottos;
    private int winMoney;

    Buyer() {
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

    public void setWinmoney(Map<LottoPrize, Integer> prizeList) {

        LottoPrize[] values = LottoPrize.values();
        for (int i = 0; i < values.length; i++) {
            if (prizeList.get(values[i]) == null)
                continue;

            int winCount = prizeList.get(values[i]);
            if (winCount != 0)
                winMoney += values[i].getLottoPrizeMoney() * winCount;

        }

    }

    public int getWinMoney() {
        return this.winMoney;
    }

    public int getMoney() {
        return this.money;
    }

}
