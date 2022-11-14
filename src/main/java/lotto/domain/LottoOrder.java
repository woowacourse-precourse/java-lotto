package lotto.domain;

import java.util.List;

public class LottoOrder {
    private static final int LOTTO_PRICE = 1000; // 로또 1장의 가격
    private List<Lotto> lottoTickets;
    private int lottoCount;

    public LottoOrder(String moneyCommand) {
        int lottoCount = calcLottoCount(moneyCommand);

        this.lottoCount = lottoCount;
    }

    private int calcLottoCount(String moneyCommand) {
        int money = Integer.parseInt(moneyCommand);

        return money / LOTTO_PRICE;
    }
}
