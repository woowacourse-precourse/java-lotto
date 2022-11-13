package lotto.controller;

import lotto.MyLottos;

public class LottoController {
    public static MyLottos generateMyLottoInstance(int money) {
        return new MyLottos(money);
    }
}
