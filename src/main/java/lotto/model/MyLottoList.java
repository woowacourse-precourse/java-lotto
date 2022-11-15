package lotto.model;

import lotto.constant.LottoInfo;
import lotto.model.Lotto;

import java.util.List;

public class MyLottoList {
    private int count;
    private List<Lotto> lotto;

    public MyLottoList() {
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public void setLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public void setCount(int money) {
        this.count = money / LottoInfo.ONE_PRICE;
    }
}