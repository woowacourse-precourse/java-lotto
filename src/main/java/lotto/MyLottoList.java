package lotto;

import java.util.List;

public class MyLottoList {
    private int number;
    private List<Lotto> lotto;

    public MyLottoList(int money) {
        this.number = money / 1000;
    }

    public int getNumber() {
        return number;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public void setLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }
}