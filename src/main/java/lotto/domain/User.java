package lotto.domain;

import java.util.Map;

public class User {
    private int price;
    private Map<WinningLotto, Integer> winningLottoCount;
    private LottoMachine lottoMachine;

    public User(int price, Map<WinningLotto, Integer> winningLottoCount, LottoMachine lottoMachine) {
        this.price = price;
        this.winningLottoCount = winningLottoCount;
        this.lottoMachine = lottoMachine;
    }
}
