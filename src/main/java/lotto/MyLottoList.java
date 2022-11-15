package lotto;

import lotto.constant.LottoInfo;

import java.util.List;

public class MyLottoList {
    private int count;
    private List<Lotto> lotto;

    public MyLottoList(int money) {
        this.count = money / LottoInfo.ONE_PRICE;
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
}