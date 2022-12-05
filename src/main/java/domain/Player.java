package domain;

import lotto.LottoList;

public class Player {
    private long amount;
    private long totalMoney;
    private LottoList lottoList;

    public Player(long amount) {
        this.amount = amount;
        this.totalMoney = 0;
        this.lottoList = new LottoList(amount);
    }

    public static Player of(long amount) {
        return new Player(amount);
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public void addTotalMoney(long money) {
        this.totalMoney += money;
    }

    public long getAmount() {
        return amount;
    }
}
